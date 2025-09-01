/*
 * Copyright (C) 2025 Saien Naidu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Managers;

// IMPORTS
import Driver.dbDriver;
import Objects.Degree;
import Objects.Faculty;
import Objects.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saien Naidu
 */
public class DegManager {

    // FIELDS
    private Degree[] degrees = new Degree[1000];
    private int size;
    private final dbDriver db = new dbDriver();
    private final UniManager um = new UniManager();
    private final FacManager fm = new FacManager();
    private int[] tableArr = new int[1000];

    // CONSTRUCTOR
    /**
     * Fetch all the Degrees from the DB and save it into the array
     */
    public DegManager() {
        try {
            // Fetch data
            ResultSet rs = db.query("SELECT * FROM Degree_Table;");

            // If there is more data;
            while (!rs.isLast()) {
                // Save Degree into array
                degrees[size] = createDeg(rs, size);
                // Increment size
                size++;
            }

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #08: Failed while retrieving Degrees from DB.");
        }
    }

    // PROPERTIES
    // Create and return a Degree object using a specific row from the DB
    private Degree createDeg(ResultSet rs, int row) {
        try {
            // Prepare the next row of results
            rs.absolute(row + 1);

            // Get the value of each column in the row
            int ID = rs.getInt("ID");
            String name = rs.getString("DegreeName");
            int uni = rs.getInt("UniversityID");
            int fac = rs.getInt("FacultyID");
            String desc = rs.getString("Description");

            // Create new Degree object using the values, then return it
            return (new Degree(ID, name, um.getUniWithID(uni), fm.getFacWithID(fac), desc));

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #08: Failed while retrieving Degrees from DB.");
        }

        return null;
    }

    /**
     * Fetch a degree with a specific ID from the array
     *
     * @param ID The ID of the Degree Object that you want to fetch
     * @return The matching Degree Object
     */
    public Degree getDegWithID(int ID) {
        // Go through every entry in the array until a match is found
        for (int i = 0; i < size; i++) {
            int current = degrees[i].getDegreeID();
            // If match found:
            if (current == ID) {
                // Return current Degree object
                return degrees[i];
            }
        }
        // If no match is found, return nothing
        return null;
    }

    /**
     * Fetch list of degrees based on DB query
     *
     * @param query The query to send to the DB
     * @return Returns the list of Degree Objects matching the query
     */
    public Degree[] getDegWithQuery(String query) {
        try {
            // Fetch data
            ResultSet rs = db.query(query);
            // Instantiate temporary Degree array with the length equal to that of the class's degree array
            Degree[] temp = new Degree[size];
            // Keep track of the length of the array
            int tempSize = 0;

            // If there is more data:
            while (!rs.isLast()) {
                // Create a Degree Object using the row's data and save it into the temporaray array
                temp[tempSize] = createDeg(rs, tempSize);
                // Increment size
                tempSize++;
                /*
                Error handling:
                If the results are found to be empty:
                (i.e. there are no degrees that satisfy the DB query)
                 */
                if ((tempSize + 1) >= this.size) {
                    // Create a degree array that can only hold 1 entry
                    Degree[] error = new Degree[1];
                    // Create a useless Degree object with a name of "None"
                    error[0] = new Degree(0, "None", null, null, null);
                    // return this Degree object and interrupt this method
                    return error;
                    // This means that the word "None" will display on the table
                }
            }

            // Instantiate output array with a size that's equal to the amount of results
            Degree[] output = new Degree[tempSize];
            // Copy array
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i];
            }
            // Return the output array
            return output;

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #09: Failed while retrieving specific Degrees from DB.");
        }
        return null;
    }

    /**
     * Create a table row model using all the names of all the degrees
     *
     * @return A table row model
     */
    public Object[][] createTable() {
        // Instantiate model with length equal to that of the class's degree array
        Object[][] data = new Object[size][1];
        // The program will also need to store an array of the IDs of the degrees being used
        int[] tempTableArr = new int[size];

        // Go through each degree name and save it to the model array
        // Also go through each degree ID and save it to the integer array
        for (int i = 0; i < size; i++) {
            data[i][0] = degrees[i].getName();
            tempTableArr[i] = degrees[i].getDegreeID();
        }

        // Store the integer array for future use
        tableArr = tempTableArr;

        // Return the model
        return data;
    }

    /**
     * Create a table row model using all the names of specific degrees
     *
     * @param input The list of Degree Objects to use
     * @return A table row model
     */
    public Object[][] createTable(Degree[] input) {

        // Instantiate model with size equal to the length of the given degree array
        Object[][] data = new Object[input.length][1];
        // The program will also need to store an array of the IDs of the degrees being used
        int[] tempTableArr = new int[input.length];

        // Go through each degree name and save it to the model array
        // Also go through each degree ID and save it to the integer array
        for (int i = 0; i < input.length; i++) {
            data[i][0] = input[i].getName();
            tempTableArr[i] = input[i].getDegreeID();
        }

        // Store the integer array for future use
        tableArr = tempTableArr;

        // Return the model
        return data;
    }

    /**
     * Create a table row model using all the names of degrees that belong to a
     * specific faculty
     *
     * @param fac The Faculty Object to use
     * @return A table row model
     */
    public Object[][] createTable(Faculty fac) {

        // Instantiate temporary model with size equal to the length of the given faculty array
        Object[][] temp = new Object[size][1];
        // Keep track of the amount of results
        int tempSize = 0;

        // Go through each Degree in the class's degree array
        for (int i = 0; i < size; i++) {
            // If the ID of the degree's faculty matches that of the given faculty:
            if (degrees[i].getFac().getID() == (fac.getID())) {
                // Save the name of the degree into the temporary array
                temp[tempSize][0] = degrees[i].getName();
                // Increment size
                tempSize++;
            }
        }

        // The program will also need to store an array of the IDs of the degrees being used
        // Instantiate an integer array with size equal to the length of the temporary model array
        int[] tempTableArr = new int[tempSize];
        // Keep track of the size of the integer array
        int tempTableArrSize = 0;

        // Go through each degree in the class array
        for (int i = 0; i < size; i++) {
            // If the ID of the current degree's faculty is equal to the one given: 
            if (degrees[i].getFac().getID() == (fac.getID())) {
                // Save the degree's ID into the integer array
                tempTableArr[tempTableArrSize] = degrees[i].getDegreeID();
                // Increment size
                tempTableArrSize++;
            }
        }

        // Instantiate output model with the length equal to that of the size of the temporary model
        Object[][] output = new Object[tempSize][1];
        // Copy array
        for (int i = 0; i < tempSize; i++) {
            output[i][0] = temp[i][0];
        }

        // Store the integer array for future use
        tableArr = tempTableArr;

        // Return output model
        return output;
    }

    /**
     * Return a list of degrees that match the filter
     *
     * @param f The filter containing the user's choices
     * @return The list of Degree Objects that satisfy the filter
     */
    public Degree[] degreeFinder(Filter f) {
        // SETUP
        ReqManager rm = new ReqManager();
        Degree[] output = new Degree[size];

        // To start, the list will contain all the degrees in the DB
        for (int i = 0; i < size; i++) {
            output[i] = degrees[i];
        }

        // Track the size, which equals the amount of degrees
        int outputSize = size;

        // <editor-fold defaultstate="collapsed" desc="Search using user's marks">
        // If 'Use your marks' is selected:
        if (f.isUseMarks()) {
            // Get the IDs of the degrees that the user has met the requirements of
            int[] IDs = rm.reqMet();
            // Create a temporary degree array with a size equal to the amount of IDs
            Degree[] temp = new Degree[IDs.length];

            // Go through each ID, getting the Degree using it and save it to the Degree array.
            for (int i = 0; i < IDs.length; i++) {
                temp[i] = getDegWithID(IDs[i]);
            }

            // The output array becomes this Degree array
            output = new Degree[temp.length];
            output = temp;
            // Keep track of the size
            outputSize = temp.length;

        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Search based on Location">
        // If the user has a location selected:
        // First check to see if this is true
        boolean locationOn = false;
        // The selected provinces will need to be added to the query
        String locations = "";

        // If user has selected KZN:
        if (f.isKzn()) {
            // Adds the province to the string, and what to add is based on whether this is the first location or not
            locations = addLocation(locations, "'KZN'");
            // Declare that the user does have at least one location selected
            locationOn = true;
        }
        // If user has selected Gauteng:
        if (f.isGauteng()) {
            locations = addLocation(locations, "'G'");
            locationOn = true;
        }
        // If user has selected Eastern Cape:
        if (f.isEastcape()) {
            locations = addLocation(locations, "'EC'");
            locationOn = true;
        }
        // If user has selected Western Cape:
        if (f.isWestcape()) {
            locations = addLocation(locations, "'WC'");
            locationOn = true;
        }
        // If user has selected Free State:
        if (f.isFreestate()) {
            locations = addLocation(locations, "'FS'");
            locationOn = true;
        }
        // If user has selected North West Province:
        if (f.isNorthwest()) {
            locations = addLocation(locations, "'NW'");
            locationOn = true;
        }
        // If user has selected Mpumalanga:
        if (f.isMpumalanga()) {
            locations = addLocation(locations, "'M'");
            locationOn = true;
        }
        // If user has selected Limpopo:
        if (f.isLimpopo()) {
            locations = addLocation(locations, "'L'");
            locationOn = true;
        }

        // If the user has selected at least one province:
        if (locationOn) {
            // Create a degree array with a size equal to the current size of the output array
            Degree[] results = new Degree[outputSize];

            // Fetch the desired Degrees from the DB using a query
            results = getDegWithQuery("""
                                      SELECT
                                          Degree_Table.ID,
                                          DegreeName,
                                          Degree_Table.UniversityID,
                                          Degree_Table.FacultyID,
                                          Degree_Table.Description
                                      FROM
                                          Degree_Table
                                          INNER JOIN (
                                              University_Table
                                              INNER JOIN Faculty_Table ON University_Table.ID = Faculty_Table.UniversityID
                                          ) ON (Degree_Table.UniversityID = University_Table.ID)
                                          AND (Degree_Table.FacultyID = Faculty_Table.ID)
                                      WHERE
                                          Location IN (""" + locations + ");");

            // Declare a boolean that will turn true after the last row of the results is reached
            boolean endReached = false;
            // Reset the size of the output array
            outputSize = 0;
            // While the end of the results has not been reached
            // AND the output array size is less than that of the result array (which it always should be)
            while (!endReached && (outputSize < results.length)) {
                // If the result in the current row is not nothing
                if (results[outputSize] != null) {
                    // Increment size
                    outputSize++;
                } else { // Otherwise
                    // Declare that the end of the results has been reached and end the while loop
                    endReached = true;
                }
            }

            // Create a temporary Degree array with a size equal to that of the output array
            Degree[] temp = new Degree[outputSize];
            // Keep track of the size of the temporary array
            int tempSize = 0;
            // Add the degrees that are part of both the output and the result array to the temporary array
            for (Degree output1 : output) {
                for (Degree result : results) {
                    // If the degree is in both arrays:
                    if (output1.getDegreeID() == result.getDegreeID()) {
                        // Add the degree into the temporary array
                        temp[tempSize] = result;
                        // Increment size
                        tempSize++;
                    }
                }
            }

            // Reset the output array, giving it a size equal to that of the temporary array
            output = new Degree[tempSize];
            // Copy the array
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i];
            }
            // Update the output array size
            outputSize = tempSize;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Search based on Faculty">
        // If the user has a location selected:
        // First check to see if this is true
        boolean facultyOn = false;
        // The selected faculties will need to be added to the query
        String faculties = "";

        // If user has selected Commerce:
        if (f.isCommerce()) {
            // Adds the faculty to the string, and what to add is based on whether this is the first faculty or not
            faculties = addFaculty(faculties, "'%Commerce%'");
            // Declare that the user does have at least one faculty selected
            facultyOn = true;
        }
        // If user has selected Engineering:
        if (f.isEngineering()) {
            faculties = addFaculty(faculties, "'%Engineering%'");
            facultyOn = true;
        }
        // If user has selected Health Sciences:
        if (f.isHealth()) {
            faculties = addFaculty(faculties, "'%Health%'");
            facultyOn = true;
        }
        // If user has selected Law:
        if (f.isLaw()) {
            faculties = addFaculty(faculties, "'%Law%'");
            facultyOn = true;
        }
        // If user has selected Humanities:
        if (f.isHumanities()) {
            faculties = addFaculty(faculties, "'%Humanities%'");
            facultyOn = true;
        }
        // If user has selected Sciences:
        if (f.isSciences()) {
            faculties = addFaculty(faculties, "'%Science%'");
            facultyOn = true;
        }

        // If the user has selected at least one faculty:
        if (facultyOn) {
            // Create a degree array with a size equal to the current size of the output array
            Degree[] results = new Degree[outputSize];

            // Fetch the degrees belonging to the selected faculties from the DB
            results = getDegWithQuery("""
                                      SELECT
                                          Degree_Table.ID,
                                          DegreeName,
                                          Degree_Table.UniversityID,
                                          Degree_Table.FacultyID,
                                          Degree_Table.Description
                                      FROM
                                          Degree_Table
                                          INNER JOIN (
                                              University_Table
                                              INNER JOIN Faculty_Table ON University_Table.ID = Faculty_Table.UniversityID
                                          ) ON (Degree_Table.UniversityID = University_Table.ID)
                                          AND (Degree_Table.FacultyID = Faculty_Table.ID)
                                      WHERE
                                          Degree_Table.FacultyName LIKE """
                    + faculties + ";");

            // Declare a boolean that will turn true after the last row of the results is reached
            boolean endReached = false;
            // Reset the size of the output array
            outputSize = 0;
            // While the end of the results has not been reached
            // AND the output array size is less than that of the result array (which it always should be)
            while (!endReached && (outputSize < results.length)) {
                // If the result in the current row is not nothing
                if (results[outputSize] != null) {
                    // Increment size
                    outputSize++;
                } else { // Otherwise
                    // Declare that the end of the results has been reached and end the while loop
                    endReached = true;
                }
            }

            // Create a temporary Degree array with a size equal to that of the output array
            Degree[] temp = new Degree[outputSize];
            // Keep track of the size of the temporary array
            int tempSize = 0;
            // Add the degrees that are part of both the output and the result array to the temporary array
            for (Degree output1 : output) {
                for (Degree result : results) {
                    // If the degree is in both arrays:
                    if (output1.getDegreeID() == result.getDegreeID()) {
                        // Add the degree into the temporary array
                        temp[tempSize] = result;
                        // Increment size
                        tempSize++;
                    }
                }
            }

            // Reset the output array, giving it a size equal to that of the temporary array
            output = new Degree[tempSize];
            // Copy the array
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i];
            }
            // Update the output array size
            outputSize = tempSize;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Search based on University">
        // If the user has selected to include/exclude specific university/universities
        boolean includeOn = f.isInclude();
        boolean excludeOn = f.isExclude();

        // If the user has selected include:
        if (includeOn) {
            // Fetch the names of the selected universities
            String uni1 = f.getUni1();
            String uni2 = f.getUni2();
            String uni3 = f.getUni3();

            // The selected universities will need to be added to the query
            String universities = "";

            // Check to see if the user has not selected include without selecting a university:
            boolean notNone = false;
            // If a university has been selected in Combo Box 1:
            if (!uni1.equals("None")) {
                // Adds the university to the string, and what to add is based on whether this is the first university or not
                universities = addUniversity(universities, uni1, true);
                // Declare that at least one university was actually selected
                notNone = true;
            }
            // If a university has been selected in Combo Box 2:
            if (!uni2.equals("None")) {
                universities = addUniversity(universities, uni2, true);
                notNone = true;
            }
            // If a university has been selected in Combo Box 3:
            if (!uni3.equals("None")) {
                universities = addUniversity(universities, uni3, true);
                notNone = true;
            }

            // If at least 1 university has been selected:
            if (notNone) {
                // Create a degree array with a size equal to the current size of the output array
                Degree[] results = new Degree[outputSize];

                // Fetch the degrees belonging to the selected universities from the DB
                results = getDegWithQuery("""
                                          SELECT
                                              Degree_Table.ID,
                                              DegreeName,
                                              Degree_Table.UniversityID,
                                              Degree_Table.FacultyID,
                                              Degree_Table.Description
                                          FROM
                                              Degree_Table
                                              INNER JOIN (
                                                  University_Table
                                                  INNER JOIN Faculty_Table ON University_Table.ID = Faculty_Table.UniversityID
                                              ) ON (Degree_Table.UniversityID = University_Table.ID)
                                              AND (Degree_Table.FacultyID = Faculty_Table.ID)
                                          WHERE
                                              University_Table.UniversityName = """
                        + universities + ";");

                // Declare a boolean that will turn true after the last row of the results is reached
                boolean endReached = false;
                // Reset the size of the output array
                outputSize = 0;
                // While the end of the results has not been reached
                // AND the output array size is less than that of the result array (which it always should be)
                while (!endReached && (outputSize < results.length)) {
                    // If the result in the current row is not nothing
                    if (results[outputSize] != null) {
                        // Increment size
                        outputSize++;
                    } else { // Otherwise
                        // Declare that the end of the results has been reached and end the while loop
                        endReached = true;
                    }
                }

                // Create a temporary Degree array with a size equal to that of the output array
                Degree[] temp = new Degree[outputSize];
                // Keep track of the size of the temporary array
                int tempSize = 0;
                // Add the degrees that are part of both the output and the result array to the temporary array
                for (Degree output1 : output) {
                    for (Degree result : results) {
                        // If the degree is in both arrays:
                        if (output1.getDegreeID() == result.getDegreeID()) {
                            // Add the degree into the temporary array
                            temp[tempSize] = result;
                            // Increment size
                            tempSize++;
                        }
                    }
                }

                // Reset the output array, giving it a size equal to that of the temporary array
                output = new Degree[tempSize];
                // Copy the array
                for (int i = 0; i < tempSize; i++) {
                    output[i] = temp[i];
                }
                // Update the output array size
                outputSize = tempSize;
            }
        }

        // If the user has selected exclude:
        if (excludeOn) {
            // Fetch the names of the selected universities
            String uni1 = f.getUni1();
            String uni2 = f.getUni2();
            String uni3 = f.getUni3();

            // The selected universities will need to be added to the query
            String universities = "";

            // Check to see if the user has not selected include without selecting a university:
            boolean notNone = false;
            // If a university has been selected in Combo Box 1:
            if (!uni1.equals("None")) {
                // Adds the university to the string, and what to add is based on whether this is the first university or not
                universities = addUniversity(universities, uni1, false);
                // Declare that at least one university was actually selected
                notNone = true;
            }
            // If a university has been selected in Combo Box 2:
            if (!uni2.equals("None")) {
                universities = addUniversity(universities, uni2, false);
                notNone = true;
            }
            // If a university has been selected in Combo Box 3:
            if (!uni3.equals("None")) {
                universities = addUniversity(universities, uni3, false);
                notNone = true;
            }

            // If at least 1 university has been selected:
            if (notNone) {
                // Create a degree array with a size equal to the current size of the output array
                Degree[] results = new Degree[outputSize];

                // Fetch the degrees belonging to the selected universities from the DB
                results = getDegWithQuery("""
                                          SELECT
                                              Degree_Table.ID,
                                              DegreeName,
                                              Degree_Table.UniversityID,
                                              Degree_Table.FacultyID,
                                              Degree_Table.Description
                                          FROM
                                              Degree_Table
                                              INNER JOIN (
                                                  University_Table
                                                  INNER JOIN Faculty_Table ON University_Table.ID = Faculty_Table.UniversityID
                                              ) ON (Degree_Table.UniversityID = University_Table.ID)
                                              AND (Degree_Table.FacultyID = Faculty_Table.ID)
                                          WHERE
                                              University_Table.UniversityName <> """
                        + universities + ";");

                // Declare a boolean that will turn true after the last row of the results is reached
                boolean endReached = false;
                // Reset the size of the output array
                outputSize = 0;
                // While the end of the results has not been reached
                // AND the output array size is less than that of the result array (which it always should be)
                while (!endReached && (outputSize < results.length)) {
                    // If the result in the current row is not nothing
                    if (results[outputSize] != null) {
                        // Increment size
                        outputSize++;
                    } else { // Otherwise
                        // Declare that the end of the results has been reached and end the while loop
                        endReached = true;
                    }
                }

                // Create a temporary Degree array with a size equal to that of the output array
                Degree[] temp = new Degree[outputSize];
                // Keep track of the size of the temporary array
                int tempSize = 0;
                // Add the degrees that are part of both the output and the result array to the temporary array
                for (Degree output1 : output) {
                    for (Degree result : results) {
                        // If the degree is in both arrays:
                        if (output1.getDegreeID() == result.getDegreeID()) {
                            // Add the degree into the temporary array
                            temp[tempSize] = result;
                            // Increment size
                            tempSize++;
                        }
                    }
                }

                // Reset the output array, giving it a size equal to that of the temporary array
                output = new Degree[tempSize];
                // Copy the array
                for (int i = 0; i < tempSize; i++) {
                    output[i] = temp[i];
                }
                // Update the output array size
                outputSize = tempSize;
            }

        }
        // </editor-fold>

        // Return the output array
        return output;
    }

    // Add a location to a query
    private String addLocation(String original, String toAdd) {
        // If there are currently no locations in the query
        if (original.equals("")) {
            // Only return the location
            return toAdd;
        } else { // Otherwise
            // Return the new location appended to the others while maintaining the integrity of the query
            return original + ", " + toAdd;
        }
    }

    // Add a faculty to a query
    private String addFaculty(String original, String toAdd) {
        // If there are currently no faculties in the query
        if (original.equals("")) {
            // Only return the faculty
            return toAdd;
        } else { // Otherwise
            // Return the new faculty appended to the others while maintaining the integrity of the query
            return original + "\nOR Degree_Table.FacultyName LIKE " + toAdd;
        }
    }

    // Add a faculty to a query
    private String addUniversity(String original, String toAdd, boolean include) {
        // If there are currently no university in the query
        if (original.equals("")) {
            // Only return the university
            return "'" + toAdd + "'";
        } else if (include) { //Otherwise, if include is selected:
            // Return the new university appended to the others while maintaining the integrity of the query
            return original + "\nOR University_Table.UniversityName = '" + toAdd + "'";
        } else { // Otherwise
            // Return the new university appended to the others while maintaining the integrity of the query
            return original + "\nAND University_Table.UniversityName <> '" + toAdd + "'";
        }
    }

    /**
     * Return the IDs of the degrees that were used in the making of the latest
     * table row model
     *
     * @return The list of IDs
     */
    public int[] getTableArr() {
        return tableArr;
    }
}
