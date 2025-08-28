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
    
    private University[] universities = new University[10];
    private int size = 0;
    private final dbDriver db = new dbDriver();
    
    public UniManager(){
        try {
            ResultSet rs = db.query("SELECT * FROM University_Table;");

            while(!rs.isLast()){
                universities[size] = createUni(rs, size);
                size++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #04: Failed while retrieving Universities from DB.");
        }
    }
    
    private University createUni(ResultSet rs, int row){
        try {
            rs.absolute(row + 1);
            
            int id = rs.getInt("ID");
            String name = rs.getString("UniversityName");
            String desc = rs.getString("Description");
            String location = rs.getString("Location");
            int rank = rs.getInt("Rank");
            int estb = rs.getInt("Established");
            int students = rs.getInt("Students");
            double accRate = rs.getDouble("AcceptanceRate");
            
            return (new University(id, name, desc, location, rank, estb, students, accRate));

        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #04: Failed while retrieving Universities from DB.");
        }
        return null;
    }
    
    public University getUniWithID(int ID) {
        for (int i = 0; i < size; i++) {
            int current = universities[i].getID();
            if (current == ID) {
                return universities[i];
            }
        }
        return null;
    }
    
    public University[] getUniWithLocation(String location) {
        University[] output = new University[size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            String current = universities[i].getLocation();
            if (current.equalsIgnoreCase(location)) {
                output[size] = universities[i];
                size++;
            }
        }
        return output;
    }
    
    public University[] getUniWithName(String query) {
        try {
            ResultSet rs = db.query(query);
            University[] temp = new University[size];
            int size = 0;
            
            while (!rs.isLast()) {
                temp[size] = createUni(rs, size);
                size++;
                if ((size + 1) >= this.size) {
                    University[] error = new University[1];
                    error[0] = new University(0, "None", null, null, 0, 0, 0, 0);
                    return error;
                }
            }
            
            University[] output = new University[size];
            for (int i = 0; i < size; i++) {
                output[i] = temp[i];
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #05: Failed while retrieving University with a specific name from DB.");
        }
        return null;
    }
    
    public University[] getAll() {
        return universities;
    }
    
    public Object[][] createTable() {
        Object[][] data = new Object[size][1];
        
        for (int i = 0; i < size; i++) {
            data[i][0] = universities[i].getName();
        }
        
        return data;
    }
    
    public Object[][] createTable(University[] input) {
        Object[][] data = new Object[input.length][1];
        
        for (int i = 0; i < input.length; i++) {
            data[i][0] = input[i].getName();
        }
        
        return data;
    }
}
