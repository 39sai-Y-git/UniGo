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
package Objects;

import java.io.File;
import java.io.FileNotFoundException;
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
    private int[] degrees;
    private int size;
    
    // CONSTRUCTOR
    // Uses data from text file
    public SavedDegrees(String filePath){
        try {
            File file = new File(filePath);
            Scanner fileSC = new Scanner(file);
            while (fileSC.hasNext()){
                int degreeID = fileSC.nextInt();
                degrees[size] = degreeID;
                size++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SavedDegrees.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #03: SavedDegrees file not found");
        }
    }

    // GETTER
    public int[] getSavedDegrees() {
        return degrees;
    }
}
