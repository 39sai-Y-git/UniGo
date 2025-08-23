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
    
    private University[] universities;
    private int size;
    
    public UniManager(String query){
        try {
            dbDriver db = new dbDriver();
            ResultSet rs = db.query(query);

            if(!rs.isLast()){
                rs.absolute(size);
                
                String name = rs.getString("UniversityName");
                String desc = rs.getString("Description");
                String location = rs.getString("Location");
                int rank = rs.getInt("Rank");
                int estb = rs.getInt("Established");
                int students = rs.getInt("Students");
                double accRate = rs.getDouble("AcceptanceRate");
                
                University uni = new University(name, desc, location, rank, estb, students, accRate);
                universities[size] = uni;
                size++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #03: Failed while retrieving Universities from DB.");
        }
    }
}
