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
import Objects.Degree;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saien Naidu
 */
public class DegManager {
    private Degree[] degrees;
    private int size;
    private dbDriver db = new dbDriver();
    private UniManager um = new UniManager();
    private FacManager fm = new FacManager();
    
    public DegManager(){
        try {
            ResultSet rs = db.query("SELECT * FROM Faculty_Table;");

            while(!rs.isLast()){
                degrees[size] = createDeg(rs, size);
                size++;
            }
            degrees[size] = createDeg(rs, size);
            size++;

        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #08: Failed while retrieving Degrees from DB.");
        }
    }
    
    private Degree createDeg(ResultSet rs, int row){
        try {
            rs.absolute(row);
            
            int ID = rs.getInt("DegreeID");
            String name = rs.getString("DegreeName");
            int uni = rs.getInt("UniversityID");
            int fac = rs.getInt("FacultyID");
            String desc = rs.getString("Description");
            
            return (new Degree(ID, name, um.getUniWithID(ID), fm.getFacWithID(ID), desc));
            
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #08: Failed while retrieving Degrees from DB.");
        }
        
        return null;
    }
    
    public Degree getDegWithID(int ID) {
        for (int i = 0; i < size; i++) {
            int current = degrees[i].getDegreeID();
            if (current == ID) {
                return degrees[i];
            }
        }
        return null;
    }
    
    public Degree[] getDegWithQuery(String query) {
        try {
            ResultSet rs = db.query(query);
            Degree[] temp = new Degree[size];
            int size = 0;
            
            while (!rs.isLast()) {
                temp[size] = createDeg(rs, size);
                size++;
            }
            temp[size] = createDeg(rs, size);
            size++;
            
            return temp;
            
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #09: Failed while retrieving specific Degrees from DB.");
        }
        return null;
    }
}
