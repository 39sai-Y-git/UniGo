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
import Objects.Requirement;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saien
 */
public class ReqManager {
    private Requirement[] requirements;
    private int size;
    private dbDriver db = new dbDriver();
    private DegManager dm = new DegManager();
    
    public ReqManager(){
        try {
            ResultSet rs = db.query("SELECT * FROM Faculty_Table;");
            size = 1;

            while(!rs.isLast()){
                requirements[size] = createReq(rs, size);
                size++;
            }
            requirements[size] = createReq(rs, size);
            size++;

        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #10: Failed while retrieving Requirements from DB.");
        }
        
        initUserMarks();
    }
    
    private Requirement createReq(ResultSet rs, int row){
        try {
            rs.absolute(row);
            
            int id = rs.getInt("ID");
            int degID = rs.getInt("DegreeID");
            
            String hl = rs.getString("HL");
            String hlC = hl.substring(0, 2);
            int hlM = Integer.parseInt(hl.substring(3));
            
            String fal = rs.getString("FAL");
            String falC = fal.substring(0, 2);
            int falM = Integer.parseInt(fal.substring(3));
            
            String math = rs.getString("MATH");
            String mathC = math.substring(0, 2);
            int mathM = Integer.parseInt(math.substring(3));
            
            String opt1 = rs.getString("OPT1");
            String opt1C = opt1.substring(0, 2);
            int opt1M = Integer.parseInt(opt1.substring(3));
            
            String opt2 = rs.getString("OPT2");
            String opt2C = opt2.substring(0, 2);
            int opt2M = Integer.parseInt(opt2.substring(3));
            
            String opt3 = rs.getString("OPT3");
            String opt3C = opt3.substring(0, 2);
            int opt3M = Integer.parseInt(opt3.substring(3));
            
            int lo = 50;
            int aps = rs.getInt("APS");
            
            return (new Requirement(dm.getDegWithID(degID), id, hlM, hlC, falM, falC, mathM, mathC, opt1M, opt1C, opt2M, opt2C, opt3M, opt3C, lo, aps));
            
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #10: Failed while retrieving Requirements from DB.");
        }
        
        return null;
    }
    
    private void initUserMarks() {
        File file = new File("data//UserMarks.txt");
        try {
            Scanner fileSC = new Scanner(file).useDelimiter("#");
            int aps = 0;
            
            String hl = fileSC.next();
            String hlC = hl.substring(0, 2);
            int hlM = Integer.parseInt(hl.substring(3));
            aps += calcAPS(hlM);
            
            String fal = fileSC.next();
            String falC = fal.substring(0, 2);
            int falM = Integer.parseInt(fal.substring(3));
            aps += calcAPS(falM);
            
            String math = fileSC.next();
            String mathC = math.substring(0, 2);
            int mathM = Integer.parseInt(math.substring(3));
            aps += calcAPS(mathM);
            
            String opt1 = fileSC.next();
            String opt1C = opt1.substring(0, 2);
            int opt1M = Integer.parseInt(opt1.substring(3));
            aps += calcAPS(opt1M);
            
            String opt2 = fileSC.next();
            String opt2C = opt2.substring(0, 2);
            int opt2M = Integer.parseInt(opt2.substring(3));
            aps += calcAPS(opt2M);
            
            String opt3 = fileSC.next();
            String opt3C = opt3.substring(0, 2);
            int opt3M = Integer.parseInt(opt3.substring(3));
            aps += calcAPS(opt3M);
            
            int lo = fileSC.nextInt();
            
            requirements[0] = new Requirement(null, 0, hlM, hlC, falM, falC, mathM, mathC, opt1M, opt1C, opt2M, opt2C, opt3M, opt3C, lo, aps);
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReqManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #11: UserMarks file not found.");
        }
    }
    
    private int calcAPS(int mark) {
        int rank = mark/10;
        
        return switch (rank) {
            case 4 -> 3;
            case 5 -> 4;
            case 6 -> 5;
            case 7 -> 6;
            case 8, 9, 10 -> 7;
            default -> 0;
        };
    }
}
