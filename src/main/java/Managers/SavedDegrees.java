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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saien Naidu
 */
// This class represents the SavedDegree Object
public class SavedDegrees {

    // FIELDS
    private int[] degrees = new int[250];
    private int size;
    private final String filePath = "data\\SavedDegrees.txt";

    private final DegManager dm = new DegManager();

    // CONSTRUCTOR
    /**
     * Uses data from text file
     */
    public SavedDegrees() {
        try {
            File file = new File(filePath);
            Scanner fileSC = new Scanner(file);
            while (fileSC.hasNext()) {
                int degreeID = fileSC.nextInt();
                degrees[size] = degreeID;
                size++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SavedDegrees.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #03: SavedDegrees file not found");
        }
    }

    // GETTERS
    /**
     *
     * @return The IDs of the degrees the user has saved
     */
    public int[] getSavedDegrees() {
        return degrees;
    }

    /**
     *
     * @return The amount of degrees the user has saved
     */
    public int getSize() {
        return size;
    }

    /**
     * Create a table row model using the degrees that the user has saved
     *
     * @return The table row model
     */
    public Object[][] createTable() {
        Object[][] data = new Object[size][1];

        for (int i = 0; i < size; i++) {
            data[i][0] = dm.getDegWithID(degrees[i]).getName();
        }

        return data;
    }

    /**
     * Return the list of degrees that the user has saved whose names are
     * similar to the text provided
     *
     * @param mustContain The text that the degrees must be similar to
     * @return The table row model
     */
    public Object[][] createTable(String mustContain) {
        Object[][] data = new Object[size][1];
        int j = 0;

        for (int i = 0; i < size; i++) {
            String degName = dm.getDegWithID(degrees[i]).getName();
            if (degName.toLowerCase().contains(mustContain.toLowerCase())) {
                data[j][0] = degName;
                j++;
            }
        }

        return data;
    }

    /**
     * Remove a degree from the user's saved degrees
     *
     * @param index The index of the ID to remove
     */
    public void remove(int index) {
        FileWriter fileFW = null;
        try {
            for (int i = index; i < size; i++) {
                degrees[i] = degrees[i + 1];
            }
            size--;

            fileFW = new FileWriter(filePath);
            fileFW.write("");
            for (int i = 0; i < size; i++) {
                fileFW.append(degrees[i] + "\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(SavedDegrees.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #13: Error while removing a saved degree from the text file.");

        } finally {
            try {
                fileFW.close();
            } catch (IOException ex) {
                Logger.getLogger(SavedDegrees.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error #13: Error while removing a saved degree from the text file.");
            }
        }
    }

    /**
     * Add a degree to the list of the user's saved degrees
     *
     * @param ID The ID of the Degree
     */
    public void add(int ID) {
        FileWriter fileFW = null;
        try {
            degrees[size] = ID;
            size++;

            String write = "";
            for (int i = 0; i < size; i++) {
                write += degrees[i] + "\n";
            }

            fileFW = new FileWriter(filePath);
            fileFW.write(write);
        } catch (IOException ex) {
            Logger.getLogger(SavedDegrees.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #14: Error while adding a saved degree to the text file.");
        } finally {
            try {
                fileFW.close();
            } catch (IOException ex) {
                Logger.getLogger(SavedDegrees.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error #14: Error while adding a saved degree to the text file.");
            }
        }

    }
}
