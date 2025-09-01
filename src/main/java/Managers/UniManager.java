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
import Objects.University;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saien Naidu
 */
public class UniManager {

    // FIELDS
    private University[] universities = new University[10];
    private int size = 0;
    private final dbDriver db = new dbDriver();
    private int[] tableArr = new int[10];

    // CONSTRUCTOR
    /**
     * Fetch all the universities from the DB and save it into the array
     */
    public UniManager() {
        try {
            // Fetch data
            ResultSet rs = db.query("SELECT * FROM University_Table;");

            // If there is more data
            while (!rs.isLast()) {
                // Save University into array
                universities[size] = createUni(rs, size);
                // Increment size
                size++;
            }

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #04: Failed while retrieving Universities from DB.");
        }
    }

    // PROPERTIES
    // Create and return a University object using a specific row from the DB
    private University createUni(ResultSet rs, int row) {
        try {
            // Prepare the next row of results
            rs.absolute(row + 1);

            // Get the value of each column in the row
            int id = rs.getInt("ID");
            String name = rs.getString("UniversityName");
            String desc = rs.getString("Description");
            String location = rs.getString("Location");
            int rank = rs.getInt("Rank");
            int estb = rs.getInt("Established");
            int students = rs.getInt("Students");
            double accRate = rs.getDouble("AcceptanceRate");

            // Create new University object using the values, then return it
            return (new University(id, name, desc, location, rank, estb, students, accRate));

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #04: Failed while retrieving Universities from DB.");
        }
        return null;
    }

    /**
     * Fetch University Object with a specific ID from the array
     *
     * @param ID The ID of the University Object that you want to fetch
     * @return The matching University Object
     */
    public University getUniWithID(int ID) {
        // Go through every entry in the array until a match is found
        for (int i = 0; i < size; i++) {
            int current = universities[i].getID();
            // If match found:
            if (current == ID) {
                // Return matching University object
                return universities[i];
            }
        }
        // If no match is found, return nothing
        return null;
    }

    /**
     * Fetch universities with a similar name compared to the one provided from
     * the DB
     *
     * @param query The query to send to the DB
     * @return The list of University Objects that satisfies the query
     */
    public University[] getUniWithName(String query) {
        try {
            // Fetch results
            ResultSet rs = db.query(query);
            // Instantiate temporary array with size of 0
            University[] temp = new University[size];
            int tempSize = 0;

            // If there is more data:
            while (!rs.isLast()) {
                // Create a new University object using an entry from the results and save it to the temporary array
                temp[tempSize] = createUni(rs, tempSize);
                // Increment size
                tempSize++;
                /*
                Error handling:
                If the results are found to be empty:
                (i.e. there are no universities whose name is similar to what is given)
                 */
                if ((tempSize + 1) >= this.size) {
                    // Create a university array that can only hold 1 entry
                    University[] error = new University[1];
                    // Create a useless University object with a name of "None"
                    error[0] = new University(0, "None", null, null, 0, 0, 0, 0);
                    // return this University object and interrupt this method
                    return error;
                    // This means that the word "None" will display on the table
                }
            }

            // Instantiate output array with a size that's equal to the amount of results
            University[] output = new University[tempSize];
            // Copy array
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i];
            }
            // Return output array
            return output;

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #05: Failed while retrieving University with a specific name from DB.");
        }
        // If there is an error, return null
        return null;
    }

    /**
     * Get the names of all the Universities in the DB This method is used to
     * set the models of the combo boxes in the Filter frame.
     *
     * @return The names of all the University Objects
     */
    public String[] getAll() {
        // Create empty String array with a size equal to the total amount of universities + 1
        String[] all = new String[size + 1];
        // The first entry is "None", which is what the user will pick if they don't want to choose a specific University
        all[0] = "None";
        // Save the name of every university to an entry in the string array
        for (int i = 0; i < size; i++) {
            all[i + 1] = universities[i].getName();
        }
        // return the string array
        return all;
    }

    /**
     * Create a table row model using all the names of all the universities
     *
     * @return A table row model
     */
    public Object[][] createTable() {

        // Instantiate model with length equal to that of the class's university array
        Object[][] data = new Object[size][1];
        // The program will also need to store an array of the IDs of the universities being used
        int[] tempTableArr = new int[size];

        // Go through each university name and save it to the model array
        // Also go through each university ID and save it to the integer array
        for (int i = 0; i < size; i++) {
            data[i][0] = universities[i].getName();
            tempTableArr[i] = universities[i].getID();
        }

        // Store the integer array for future use
        tableArr = tempTableArr;

        // Return the model
        return data;
    }

    /**
     * Create a table row model using all the names of specific universities
     *
     * @param input The array of University Objects to use
     * @return A table row model
     */
    public Object[][] createTable(University[] input) {

        // Instantiate model with size equal to the length of the given university array
        Object[][] data = new Object[input.length][1];
        // The program will also need to store an array of the IDs of the universities being used
        int[] tempTableArr = new int[input.length];

        // Go through each university name and save it to the model array
        // Also go through each university ID and save it to the integer array
        for (int i = 0; i < input.length; i++) {
            data[i][0] = input[i].getName();
            tempTableArr[i] = universities[i].getID();
        }

        // Store the integer array for future use
        tableArr = tempTableArr;

        // Return the model
        return data;
    }

    /**
     * Return the IDs of the universities that were used in the making of the
     * latest table row model
     *
     * @return The list of IDs
     */
    public int[] getTableArr() {
        return tableArr;
    }
}
