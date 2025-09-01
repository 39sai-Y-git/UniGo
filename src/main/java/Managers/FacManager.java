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
import Objects.Faculty;
import Objects.University;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saien Naidu
 */
public class FacManager {

    // FIELDS
    private Faculty[] faculties = new Faculty[100];
    private int size;
    private final dbDriver db = new dbDriver();
    private final UniManager um = new UniManager();
    private int[] tableArr = new int[100];

    // CONSTRUCTOR
    /**
     * Fetch all the Faculties from the DB and save it into the array
     */
    public FacManager() {
        try {
            // Fetch data
            ResultSet rs = db.query("SELECT * FROM Faculty_Table;");

            // If there is more data
            while (!rs.isLast()) {
                // Save Faculty into array
                faculties[size] = createFac(rs, size);
                // Increment size
                size++;
            }

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #06: Failed while retrieving Faculties from DB.");
        }
    }

    // PROPERTIES
    // Create and return a Faculty object using a specific row from the DB
    private Faculty createFac(ResultSet rs, int row) {
        try {
            // Prepare the next row of results
            rs.absolute(row + 1);

            // Get the value of each column in the row
            int ID = rs.getInt("ID");
            String name = rs.getString("FacultyName");
            String desc = rs.getString("Description");
            int uni = rs.getInt("UniversityID");

            // Create new Faculty object using the values, then return it
            return (new Faculty(ID, name, desc, um.getUniWithID(uni)));

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #06: Failed while retrieving Faculties from DB.");
        }

        return null;
    }

    /**
     * Fetch a faculty with a specific ID from the array
     *
     * @param ID The ID of the Faculty Object that you want to fetch
     * @return The matching Faculty Object
     */
    public Faculty getFacWithID(int ID) {
        // Go through every entry in the array until a match is found
        for (int i = 0; i < size; i++) {
            int current = faculties[i].getID();
            // If match found:
            if (current == ID) {
                // Return current Faculty object
                return faculties[i];
            }
        }
        // If no match is found, return nothing
        return null;
    }

    /**
     * Create a table row model using all the faculties that belong to a
     * specific university
     *
     * @param uni The University Object to use
     * @return A table row model
     */
    public Object[][] createTable(University uni) {
        // Instantiate temporary model with the length equal to that of the class's faculty array
        Object[][] temp = new Object[size][1];
        // Keep track of the amount of results
        int tempSize = 0;

        // Go through each faculty in the class array
        for (int i = 0; i < size; i++) {
            // If the name of the current faculty's university is equal to the one given: 
            if (faculties[i].getUni().getName().equals(uni.getName())) {
                // Save the faculty's name into the temporary model
                temp[tempSize][0] = faculties[i].getName();
                // Increment size
                tempSize++;
            }
        }

        // The program will also need to store an array of the IDs of the faculties being used
        // Create new integer array with size equal to the length of the temporary model
        int[] tempTableArr = new int[tempSize];
        // Keep track of the size of the integer array
        int tempTableArrSize = 0;

        // Go through each faculty in the class array
        for (int i = 0; i < size; i++) {
            // If the name of the current faculty's university is equal to the one given: 
            if (faculties[i].getUni().getName().equals(uni.getName())) {
                // Save the faculty's ID into the integer array
                tempTableArr[tempTableArrSize] = faculties[i].getID();
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
     * Return the IDs of the faculties that were used in the making of the
     * latest table row model
     *
     * @return The list of IDs
     */
    public int[] getTableArr() {
        return tableArr;
    }
}
