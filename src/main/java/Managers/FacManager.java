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
    private Faculty[] faculties = new Faculty[100];
    private int size;
    private final dbDriver db = new dbDriver();
    private final UniManager um = new UniManager();
    
    public FacManager(){
        try {
            ResultSet rs = db.query("SELECT * FROM Faculty_Table;");

            while(!rs.isLast()){
                faculties[size] = createFac(rs, size);
                size++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #06: Failed while retrieving Faculties from DB.");
        }
    }
    
    private Faculty createFac(ResultSet rs, int row){
        try {
            rs.absolute(row + 1);
            
            int ID = rs.getInt("ID");
            String name = rs.getString("FacultyName");
            String desc = rs.getString("Description");
            int uni = rs.getInt("UniversityID");
            
            return (new Faculty(ID, name, desc, um.getUniWithID(uni)));
            
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #06: Failed while retrieving Faculties from DB.");
        }
        
        return null;
    }
    
    public Faculty getFacWithNameAndUni(String input) {
        try {
            ResultSet rs = db.query(input);
            String name = rs.getString("FacultyName");
            int uni = rs.getInt("UniversityID");
            for (int i = 0; i < size; i++) {
                String currentName = faculties[i].getName();
                int currentUni = (faculties[i].getUni().getID());
                if (name.equals(currentName) && uni == currentUni) {
                    return faculties[i];
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #07: Failed while retrieving Faculty with a specific name and University from DB.");
        }
        
        return null;
    }
    
    public Faculty getFacWithID(int ID) {
        for (int i = 0; i < size; i++) {
            int current = faculties[i].getID();
            if (current == ID) {
                return faculties[i];
            }
        }
        return null;
    }
    
    public Faculty[] getAll() {
        return faculties;
    }
    
    public Object[][] createTable(University uni) {
        Object[][] output = new Object[1][0];
        int outputSize = 1;
        
        for (int i = 0; i < size; i++) {
            if (faculties[i].getUni().equals(uni)) {
                output = new Object[1][outputSize];
                output[0][outputSize - 1] = faculties[i].getName();
                outputSize++;
            }
        }
        
        return output;
    }
}
