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
    private Degree[] degrees = new Degree[1000];
    private int size;
    private final dbDriver db = new dbDriver();
    private final UniManager um = new UniManager();
    private final FacManager fm = new FacManager();
    private Degree[] tableArr = new Degree[1000];
    
    public DegManager(){
        try {
            ResultSet rs = db.query("SELECT * FROM Degree_Table;");

            while(!rs.isLast()){
                degrees[size] = createDeg(rs, size);
                size++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #08: Failed while retrieving Degrees from DB.");
        }
    }
    
    private Degree createDeg(ResultSet rs, int row){
        try {
            rs.absolute(row + 1);
            
            int ID = rs.getInt("ID");
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
                if ((size + 1) >= this.size) {
                    Degree[] error = new Degree[1];
                    error[0] = new Degree(0, "None", null, null, null);
                    return error;
                }
            }
            
            Degree[] output = new Degree[size];
            for (int i = 0; i < size; i++) {
                output[i] = temp[i];
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #09: Failed while retrieving specific Degrees from DB.");
        }
        return null;
    }
    
    public Object[][] createTable() {
        Object[][] data = new Object[size][1];
        
        for (int i = 0; i < size; i++) {
            data[i][0] = degrees[i].getName();
            tableArr[i] = degrees[i];
        }
        
        return data;
    }
    
    public Object[][] createTable(Degree[] input) {
        Object[][] data = new Object[input.length][1];
        
        for (int i = 0; i < input.length; i++) {
            data[i][0] = input[i].getName();
            tableArr[i] = degrees[i];
        }
        
        return data;
    }
    
    public Object[][] createTable(Faculty fac) {
        Object[][] output = new Object[1][0];
        int outputSize = 1;
        
        for (int i = 0; i < size; i++) {
            if (degrees[i].getFac().equals(fac)) {
                output = new Object[1][outputSize];
                output[0][outputSize - 1] = degrees[i].getName();
                outputSize++;
            }
        }
        
        return output;
    }
    
    public Degree[] degreeFinder(Filter f) {
        // Setup
        ReqManager rm = new ReqManager();
        Degree[] output = new Degree[size];
        
        for (int i = 0; i < size; i++) {
            output[i] = degrees[i];
        }
        
        int outputSize = size;
        
        // <editor-fold defaultstate="collapsed" desc="Search using user's marks">
        if (f.isUseMarks()) {
            int[] IDs = rm.reqMet();
            Degree[] temp = new Degree[IDs.length];
            
            for (int i = 0; i < IDs.length; i++) {
                temp[i] = getDegWithID(IDs[i]);
            }
            
            output = new Degree[temp.length];
            output = temp;
            outputSize = temp.length;
            
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Search based on Location">
        boolean locationOn = false;
        String locations = "";
        
        if (f.isKzn()) {
            locations = addLocation(locations, "'KZN'");
            locationOn = true;
        }
        if (f.isGauteng()) {
            locations = addLocation(locations, "'G'");
            locationOn = true;
        }
        if (f.isEastcape()) {
            locations = addLocation(locations, "'EC'");
            locationOn = true;
        }
        if (f.isWestcape()) {
            locations = addLocation(locations, "'WC'");
            locationOn = true;
        }
        if (f.isFreestate()) {
            locations = addLocation(locations, "'FS'");
            locationOn = true;
        }
        if (f.isNorthwest()) {
            locations = addLocation(locations, "'NW'");
            locationOn = true;
        }
        if (f.isMpumalanga()) {
            locations = addLocation(locations, "'M'");
            locationOn = true;
        }
        if (f.isLimpopo()) {
            locations = addLocation(locations, "'L'");
            locationOn = true;
        }
        
        if (locationOn) {
            Degree[] results = new Degree[outputSize];
            
            results = getDegWithQuery("SELECT\n" +
                "    Degree_Table.ID,\n" +
                "    DegreeName,\n" +
                "    Degree_Table.UniversityID,\n" +
                "    Degree_Table.FacultyID,\n" +
                "    Degree_Table.Description\n" +
                "FROM\n" +
                "    Degree_Table\n" +
                "    INNER JOIN (\n" +
                "        University_Table\n" +
                "        INNER JOIN Faculty_Table ON University_Table.ID = Faculty_Table.UniversityID\n" +
                "    ) ON (Degree_Table.UniversityID = University_Table.ID)\n" +
                "    AND (Degree_Table.FacultyID = Faculty_Table.ID)\n" +
                "WHERE\n" +
                "    Location IN ("+locations+");");
            
            boolean endReached = false;
            outputSize = 0;
            while (!endReached && (outputSize < results.length)) {
                if (!results[outputSize].equals(null)) {
                    outputSize++;
                } else {
                    endReached = true;
                }
            }
            
            Degree[] temp = new Degree[outputSize];
            int tempSize = 0;
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < results.length; j++) {
                    if (output[i].getDegreeID() == results[j].getDegreeID()) {
                        temp[tempSize] = results[j];
                        tempSize++;
                    }
                }
            }
            
            output = new Degree[tempSize];
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i];
            }
            outputSize = tempSize;
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Search based on Faculty">
        boolean facultyOn = false;
        String faculties = "";
        
        if (f.isCommerce()) {
            faculties = addFaculty(faculties, "'%Commerce%'");
            facultyOn = true;
        }
        if (f.isEngineering()) {
            faculties = addFaculty(faculties, "'%Engineering%'");
            facultyOn = true;
        }
        if (f.isHealth()) {
            faculties = addFaculty(faculties, "'%Health%'");
            facultyOn = true;
        }
        if (f.isLaw()) {
            faculties = addFaculty(faculties, "'%Law%'");
            facultyOn = true;
        }
        if (f.isHumanities()) {
            faculties = addFaculty(faculties, "'%Humanities%'");
            facultyOn = true;
        }
        if (f.isSciences()) {
            faculties = addFaculty(faculties, "'%Science%'");
            facultyOn = true;
        }
        
        if (facultyOn) {
            Degree[] results = new Degree[outputSize];
            
            results = getDegWithQuery("SELECT\n" +
                "    Degree_Table.ID,\n" +
                "    DegreeName,\n" +
                "    Degree_Table.UniversityID,\n" +
                "    Degree_Table.FacultyID,\n" +
                "    Degree_Table.Description\n" +
                "FROM\n" +
                "    Degree_Table\n" +
                "    INNER JOIN (\n" +
                "        University_Table\n" +
                "        INNER JOIN Faculty_Table ON University_Table.ID = Faculty_Table.UniversityID\n" +
                "    ) ON (Degree_Table.UniversityID = University_Table.ID)\n" +
                "    AND (Degree_Table.FacultyID = Faculty_Table.ID)\n" +
                "WHERE\n" +
                "    Degree_Table.FacultyName LIKE "
                +faculties+";");
            
            boolean endReached = false;
            outputSize = 0;
            while (!endReached && (outputSize < results.length)) {
                if (!results[outputSize].equals(null)) {
                    outputSize++;
                } else {
                    endReached = true;
                }
            }
            
            Degree[] temp = new Degree[outputSize];
            int tempSize = 0;
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < results.length; j++) {
                    if (output[i].getDegreeID() == results[j].getDegreeID()) {
                        temp[tempSize] = results[j];
                        tempSize++;
                    }
                }
            }
            
            output = new Degree[tempSize];
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i];
            }
            outputSize = tempSize;
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Search based on University">
        boolean includeOn = f.isInclude();
        boolean excludeOn = f.isExclude();
        
        if (includeOn) {
            String uni1 = f.getUni1();
            String uni2 = f.getUni2();
            String uni3 = f.getUni3();
            
            String universities = "";
            
            if (!uni1.equals("None")) {
                universities = addUniversity(universities, uni1, true);
            }
            if (!uni2.equals("None")) {
                universities = addUniversity(universities, uni2, true);
            }
            if (!uni3.equals("None")) {
                universities = addUniversity(universities, uni3, true);
            }
            
            Degree[] results = new Degree[outputSize];
            
            results = getDegWithQuery("SELECT\n" +
                "    Degree_Table.ID,\n" +
                "    DegreeName,\n" +
                "    Degree_Table.UniversityID,\n" +
                "    Degree_Table.FacultyID,\n" +
                "    Degree_Table.Description\n" +
                "FROM\n" +
                "    Degree_Table\n" +
                "    INNER JOIN (\n" +
                "        University_Table\n" +
                "        INNER JOIN Faculty_Table ON University_Table.ID = Faculty_Table.UniversityID\n" +
                "    ) ON (Degree_Table.UniversityID = University_Table.ID)\n" +
                "    AND (Degree_Table.FacultyID = Faculty_Table.ID)\n" +
                "WHERE\n" +
                "    University_Table.UniversityName = "
                +universities+";");
            
            boolean endReached = false;
            outputSize = 0;
            while (!endReached && (outputSize < results.length)) {
                if (!results[outputSize].equals(null)) {
                    outputSize++;
                } else {
                    endReached = true;
                }
            }
            
            Degree[] temp = new Degree[outputSize];
            int tempSize = 0;
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < results.length; j++) {
                    if (output[i].getDegreeID() == results[j].getDegreeID()) {
                        temp[tempSize] = results[j];
                        tempSize++;
                    }
                }
            }
            
            output = new Degree[tempSize];
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i];
            }
            outputSize = tempSize;
        }
        
        if (excludeOn) {
            String uni1 = f.getUni1();
            String uni2 = f.getUni2();
            String uni3 = f.getUni3();
            
            String universities = "";
            
            if (!uni1.equals("None")) {
                universities = addUniversity(universities, uni1, false);
            }
            if (!uni2.equals("None")) {
                universities = addUniversity(universities, uni2, false);
            }
            if (!uni3.equals("None")) {
                universities = addUniversity(universities, uni3, false);
            }
            
            Degree[] results = new Degree[outputSize];
            
            results = getDegWithQuery("SELECT\n" +
                "    Degree_Table.ID,\n" +
                "    DegreeName,\n" +
                "    Degree_Table.UniversityID,\n" +
                "    Degree_Table.FacultyID,\n" +
                "    Degree_Table.Description\n" +
                "FROM\n" +
                "    Degree_Table\n" +
                "    INNER JOIN (\n" +
                "        University_Table\n" +
                "        INNER JOIN Faculty_Table ON University_Table.ID = Faculty_Table.UniversityID\n" +
                "    ) ON (Degree_Table.UniversityID = University_Table.ID)\n" +
                "    AND (Degree_Table.FacultyID = Faculty_Table.ID)\n" +
                "WHERE\n" +
                "    University_Table.UniversityName <> "
                +universities+";");
            
            boolean endReached = false;
            outputSize = 0;
            while (!endReached && (outputSize < results.length)) {
                if (!results[outputSize].equals(null)) {
                    outputSize++;
                } else {
                    endReached = true;
                }
            }
            
            Degree[] temp = new Degree[outputSize];
            int tempSize = 0;
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < results.length; j++) {
                    if (output[i].getDegreeID() == results[j].getDegreeID()) {
                        temp[tempSize] = results[j];
                        tempSize++;
                    }
                }
            }
            
            output = new Degree[tempSize];
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i];
            }
            outputSize = tempSize;
        }
        // </editor-fold>
        
        return output;
    }
    
    private String addLocation(String original, String toAdd) {
        if (original.equals("")) {
            return toAdd;
        } else {
            return original += ", " + toAdd;
        }
    }
    
    private String addFaculty(String original, String toAdd) {
        if (original.equals("")) {
            return toAdd;
        } else {
            return original += "\nOR Degree_Table.FacultyName LIKE " + toAdd;
        }
    }
    
    private String addUniversity(String original, String toAdd, boolean include) {
        if (original.equals("")) {
            return "'" + toAdd + "'";
        } else if (include){
            return original += "\nOR University_Table.UniversityName = '" + toAdd + "'";
        } else {
            return original += "\nAND University_Table.UniversityName <> '" + toAdd + "'";
        }
    }
    
    public Degree[] getTableArr() {
        return tableArr;
    }
}
