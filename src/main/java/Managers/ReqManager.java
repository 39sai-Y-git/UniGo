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
import Objects.Requirement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    // FIELDS
    private Requirement[] requirements = new Requirement[2000];
    private int size;
    private final dbDriver db = new dbDriver();
    private final DegManager dm = new DegManager();

    // CONSTRUCTOR
    /**
     * Fetch all the Requirements from the DB and save it into the array
     */
    public ReqManager() {
        try {
            // Fetch data
            ResultSet rs = db.query("SELECT * FROM Requirement_Table;");
            // The first enrty in the array is reserved for the user's marks, which is why size starts at 1
            size = 1;

            // If there is more data;
            while (!rs.isLast()) {
                // Save Degree into array
                requirements[size] = createReq(rs, size);
                // Increment size
                size++;
            }

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #10: Failed while retrieving Requirements from DB.");
        }

        initUserMarks();
    }

    // PROPERTIES
    // Create and return a Requirement object using a specific row from the DB
    private Requirement createReq(ResultSet rs, int row) {
        try {
            // Prepare the next row of results
            rs.absolute(row + 1);

            // Fetch the requirement's ID and the requirement's degree's ID
            int id = rs.getInt("ID");
            int degID = rs.getInt("DegreeID");

            // For each subject...
            // Home Language
            // Fetch the value
            String hl = rs.getString("HL");
            // Split into the subject choice...
            String hlC = hl.substring(0, 3);
            // ...and mark
            int hlM = Integer.parseInt(hl.substring(3));

            // 1st Add Lang
            String fal = rs.getString("FAL");
            String falC = fal.substring(0, 3);
            int falM = Integer.parseInt(fal.substring(3));

            // Mathematics
            String math = rs.getString("MATH");
            String mathC = math.substring(0, 3);
            int mathM = Integer.parseInt(math.substring(3));

            // 1st Subject Choice
            String opt1 = rs.getString("OPT1");
            String opt1C = opt1.substring(0, 3);
            int opt1M = Integer.parseInt(opt1.substring(3));

            // 2nd Subject Choice
            String opt2 = rs.getString("OPT2");
            String opt2C = opt2.substring(0, 3);
            int opt2M = Integer.parseInt(opt2.substring(3));

            // 3rd Subject Choice
            String opt3 = rs.getString("OPT3");
            String opt3C = opt3.substring(0, 3);
            int opt3M = Integer.parseInt(opt3.substring(3));

            // LO has to be passed, but there's never a specific mark needed
            int lo = 50;
            // Fetch the APS
            int aps = rs.getInt("APS");

            // Create new Requirement object using the values, then return it
            return (new Requirement(id, dm.getDegWithID(degID), hlM, hlC, falM, falC, mathM, mathC, opt1M, opt1C, opt2M, opt2C, opt3M, opt3C, lo, aps));

            // Error handling
        } catch (SQLException ex) {
            Logger.getLogger(UniManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #10: Failed while retrieving Requirements from DB.");
        }

        return null;
    }

    // Initialize the user's marks
    // The user's marks are represented in the same format as a Requirement object, hence it is handled here
    private void initUserMarks() {
        // Open the file
        File file = new File("data\\UserMarks.txt");
        try {
            // Create a file scanner
            Scanner fileSC = new Scanner(file).useDelimiter("#");
            // The APS score of each subject will be summed
            int aps = 0;

            // For each subject...
            // Home Language
            // Fetch the value from the file
            String hl = fileSC.next();
            // Split into the subject choice...
            String hlC = hl.substring(0, 3);
            // ...and mark
            int hlM = Integer.parseInt(hl.substring(3));
            // Calculate APS
            aps += calcAPS(hlM);

            // 1st Add Lang
            String fal = fileSC.next();
            String falC = fal.substring(0, 3);
            int falM = Integer.parseInt(fal.substring(3));
            aps += calcAPS(falM);

            // Mathematics
            String math = fileSC.next();
            String mathC = math.substring(0, 3);
            int mathM = Integer.parseInt(math.substring(3));
            aps += calcAPS(mathM);

            // 1st Subject Choice
            String opt1 = fileSC.next();
            String opt1C = opt1.substring(0, 3);
            int opt1M = Integer.parseInt(opt1.substring(3));
            aps += calcAPS(opt1M);

            // 2nd Subject Choice
            String opt2 = fileSC.next();
            String opt2C = opt2.substring(0, 3);
            int opt2M = Integer.parseInt(opt2.substring(3));
            aps += calcAPS(opt2M);

            // 3rd Subject Choice
            String opt3 = fileSC.next();
            String opt3C = opt3.substring(0, 3);
            int opt3M = Integer.parseInt(opt3.substring(3));
            aps += calcAPS(opt3M);

            // Fetch the user's LO mark
            int lo = fileSC.nextInt();

            // Create new Requirement object using the values, then save it to the FIRST entry in the class's Requirement array
            requirements[0] = new Requirement(0, null, hlM, hlC, falM, falC, mathM, mathC, opt1M, opt1C, opt2M, opt2C, opt3M, opt3C, lo, aps);

            // Error handling
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReqManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #11: UserMarks file not found.");
        }
    }

    // Calculate the APS score recieved for a subject
    private int calcAPS(int mark) {
        int rank = mark / 10;

        return switch (rank) {
            case 0, 1, 2 ->
                1;
            case 3 ->
                2;
            case 4 ->
                3;
            case 5 ->
                4;
            case 6 ->
                5;
            case 7 ->
                6;
            case 8, 9, 10 ->
                7;
            default ->
                0;
        };
    }

    /**
     * Return a subject's full name from its abbreviation
     *
     * @param abbreviation The subject's abbreviated form (E.g. "acc")
     * @return The subject's full name (E.g. "Accounting")
     */
    public String getSubject(String abbreviation) {
        return switch (abbreviation) {
            case "acc" ->
                "Accounting";
            case "bus" ->
                "Business Studies";
            case "cat" ->
                "CAT";
            case "con" ->
                "Consumer Studies";
            case "dan" ->
                "Dance Studies";
            case "des" ->
                "Design";
            case "dra" ->
                "Dramatic Arts";
            case "edg" ->
                "EDG";
            case "eco" ->
                "Economics";
            case "geo" ->
                "Geography";
            case "his" ->
                "History";
            case "hos" ->
                "Hospitality Studies";
            case "inf" ->
                "Information Technology";
            case "lif" ->
                "Life Sciences";
            case "mar" ->
                "Marine Sciences";
            case "mus" ->
                "Music";
            case "phy" ->
                "Physical Sciences";
            case "tou" ->
                "Tourism";
            case "vis" ->
                "Visual Arts";
            default ->
                "Other";
        };
    }

    /**
     * Return a subject's abbreviation from its full name
     *
     * @param subject The subject's full name (E.g. "Accounting")
     * @return The subject's abbreviated form (E.g. "acc")
     */
    public String getAbbreviation(String subject) {
        return switch (subject) {
            case "Accounting" ->
                "acc";
            case "Business Studies" ->
                "bus";
            case "CAT" ->
                "cat";
            case "Consumer Studies" ->
                "con";
            case "Dance Studies" ->
                "dan";
            case "Design" ->
                "des";
            case "Dramatic Arts" ->
                "dra";
            case "EDG" ->
                "edg";
            case "Economics" ->
                "eco";
            case "Geography" ->
                "geo";
            case "History" ->
                "his";
            case "Hospitality Studies" ->
                "hos";
            case "Information Technology" ->
                "inf";
            case "Life Sciences" ->
                "lif";
            case "Marine Sciences" ->
                "mar";
            case "Music" ->
                "mus";
            case "Physical Sciences" ->
                "phy";
            case "Tourism" ->
                "tou";
            case "Visual Arts" ->
                "vis";
            default ->
                "oth";
        };
    }

    /**
     * Return the Requirement representing the user's marks
     *
     * @return The user's marks as a Requirement Object
     */
    public Requirement getUserMarks() {
        // The user's marks are ALWAYS held in the first entry of the class's requirement array
        return requirements[0];
    }

    /**
     * Change user's marks
     *
     * @param hlM The mark received for Home Language
     * @param hlC The subject choice for Home Language, either 'eng' or 'oth'
     * @param falM The mark received for 1st Add Lang
     * @param falC The subject choice for 1st Add Lang, either 'eng' or 'oth'
     * @param mathM The mark received for Mathematics
     * @param mathC The subject choice for Mathematics, either 'cor', 'lit' or
     * 'tec'
     * @param opt1M The mark received for the user's 1st Subject Choice
     * @param opt1C The user's 1st Subject Choice
     * @param opt2M The mark received for the user's 2nd Subject Choice
     * @param opt2C The user's 2nd Subject Choice
     * @param opt3M The mark received for the user's 3rd Subject Choice
     * @param opt3C The user's 3rd Subject Choice
     * @param lo The mark received for LO
     */
    public void setUserMarks(int hlM, String hlC, int falM, String falC, int mathM, String mathC, int opt1M, String opt1C, int opt2M, String opt2C, int opt3M, String opt3C, int lo) {
        FileWriter fileFW = null;
        try {
            // Using the user's marks, calculate the APS
            int aps = calcAPS(hlM) + calcAPS(falM) + calcAPS(mathM) + calcAPS(opt1M) + calcAPS(opt2M) + calcAPS(opt3M);
            // Create new Requirement object using the received values, then save it to the FIRST entry in the class's Requirement array
            requirements[0] = new Requirement(0, null, hlM, hlC, falM, falC, mathM, mathC, opt1M, opt1C, opt2M, opt2C, opt3M, opt3C, lo, aps);

            // Write the user's new marks to the text file (OVERWRITE)
            fileFW = new FileWriter("data\\UserMarks.txt");
            fileFW.write(hlC + hlM + "#" + falC + falM + "#" + mathC + mathM + "#" + opt1C + opt1M + "#" + opt2C + opt2M + "#" + opt3C + opt3M + "#" + lo);

            // File handling
        } catch (IOException ex) {
            Logger.getLogger(ReqManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error #12: Error while saving user's marks to text file.");
        } finally {
            try {
                fileFW.close();
            } catch (IOException ex) {
                Logger.getLogger(ReqManager.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error #12: Error while saving user's marks to text file.");
            }
        }
    }

    /**
     * Return all the requirements in the DB EXCEPT the user's marks
     *
     * @return The list of Requirement Objects
     */
    public Requirement[] getAll() {
        Requirement[] output = new Requirement[size - 1];
        for (int i = 0; i < (size - 1); i++) {
            output[i] = requirements[i + 1];
        }
        return output;
    }

    /**
     * Return all the degrees that the user has met the requirements of.
     *
     * @return The list of IDs of the degrees
     */
    public int[] reqMet() {
        // Create a new temporary Requirement array with a size equal to that of the class's Requirement array
        Requirement[] temp = new Requirement[size];
        // Keep track of the amount of degrees
        int tempSize = 0;

        // Fetch the user's marks
        Requirement user = requirements[0];

        // Go through each requirement in the DB
        for (int i = 1; i < this.size; i++) {
            // Store the current requirement
            Requirement current = requirements[i];

            /*
            / With all subjects, the user's mark has to be the same or higher than the mark specified
            / For HL, FAL and MATHS, the user's subject choice has to be the same as the requirement's specification
            /
            / For the subject choices...it's different. I will use Physics as an example to explain the complexity
            / Let's say that Physics is a requirement of the Degree
            / Physics can be the user's 1st, 2nd or 3rd choice (opt1C, opt2C or opt3C)
            / And it can be in opt1C, opt2C or opt3C of the requirement
            / Therefore, a cross check has to be used:
            /
            / The user's opt1C has to be compared with the degree's opt1C, opt2C and opt3C,
            / The user's opt2C has to be compared with the degree's opt1C, opt2C and opt3C, and
            / The user's opt3C has to be compared with the degree's opt1C, opt2C and opt3C.
            / This gives us 5 possible combinations: 123, 132, 213, 231, 312 (321 will never happen)
            /
            / If the user has Physics as their 1st choice, and the degree's opt1C is Physics, this will give us the combination: 123
            / If the user has Physics as their 2nd choice, and the degree's opt1C is Physics, this will give us the combination: 213
            / If the user has Physics as their 3rd choice, and the degree's opt1C is Physics, this will give us the combination: 231
            / If the user has Physics as their 1st choice, and the degree's opt2C is Physics, this will give us the combination: 213
            / If the user has Physics as their 2nd choice, and the degree's opt2C is Physics, this will give us the combination: 123
            / If the user has Physics as their 3rd choice, and the degree's opt2C is Physics, this will give us the combination: 132
            / If the user has Physics as their 1st choice, and the degree's opt3C is Physics, this will give us the combination: 312
            / If the user has Physics as their 2nd choice, and the degree's opt3C is Physics, this will give us the combination: 132
            / If the user has Physics as their 3rd choice, and the degree's opt3C is Physics, this will give us the combination: 123
            
            / The user's LO mark has to be 50 or above
            / The user's APS score has to be the same or above the APS score specified
            */
            if ((user.getHlChoice().equals(current.getHlChoice())) || current.getHlChoice().equals("any")) {
                if (user.getHlMark() >= current.getHlMark()) {
                    if ((user.getFalChoice().equals(current.getFalChoice())) || current.getFalChoice().equals("any")) {
                        if (user.getFalMark() >= current.getFalMark()) {
                            if ((user.getMathChoice().equals(current.getMathChoice())) || current.getMathChoice().equals("any")) {
                                if (user.getMathMark() >= current.getMathMark()) {

                                    if ((user.getOpt1Choice().equals(current.getOpt1Choice())) || current.getOpt1Choice().equals("any")) {
                                        if (user.getOpt1Mark() >= current.getOpt1Mark()) {

                                            if ((user.getOpt2Choice().equals(current.getOpt2Choice())) || current.getOpt2Choice().equals("any")) {
                                                if (user.getOpt2Mark() >= current.getOpt2Mark()) {
                                                    if ((user.getOpt3Choice().equals(current.getOpt3Choice())) || current.getOpt3Choice().equals("any")) {
                                                        if (user.getOpt3Mark() >= current.getOpt3Mark()) {
                                                            //123
                                                            if (user.getLo() >= 50) {
                                                                if (user.getAps() >= current.getAps()) {
                                                                    // Add the current degree to the array
                                                                    temp[tempSize] = requirements[i];
                                                                    // Increment size
                                                                    tempSize++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            } else if ((user.getOpt2Choice().equals(current.getOpt3Choice())) || current.getOpt3Choice().equals("any")) {
                                                if (user.getOpt2Mark() >= current.getOpt3Mark()) {
                                                    if ((user.getOpt3Choice().equals(current.getOpt2Choice())) || current.getOpt2Choice().equals("any")) {
                                                        if (user.getOpt3Mark() >= current.getOpt2Mark()) {
                                                            //132
                                                            if (user.getLo() >= 50) {
                                                                if (user.getAps() >= current.getAps()) {
                                                                    temp[tempSize] = requirements[i];
                                                                    tempSize++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    } else if ((user.getOpt1Choice().equals(current.getOpt2Choice())) || current.getOpt2Choice().equals("any")) {
                                        if (user.getOpt1Mark() >= current.getOpt2Mark()) {

                                            if ((user.getOpt2Choice().equals(current.getOpt1Choice())) || current.getOpt1Choice().equals("any")) {
                                                if (user.getOpt2Mark() >= current.getOpt1Mark()) {
                                                    if ((user.getOpt3Choice().equals(current.getOpt3Choice())) || current.getOpt3Choice().equals("any")) {
                                                        if (user.getOpt3Mark() >= current.getOpt3Mark()) {
                                                            //213
                                                            if (user.getLo() >= 50) {
                                                                if (user.getAps() >= current.getAps()) {
                                                                    temp[tempSize] = requirements[i];
                                                                    tempSize++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            } else if ((user.getOpt2Choice().equals(current.getOpt3Choice())) || current.getOpt3Choice().equals("any")) {
                                                if (user.getOpt2Mark() >= current.getOpt3Mark()) {
                                                    if ((user.getOpt3Choice().equals(current.getOpt1Choice())) || current.getOpt1Choice().equals("any")) {
                                                        if (user.getOpt3Mark() >= current.getOpt1Mark()) {
                                                            //231
                                                            if (user.getLo() >= 50) {
                                                                if (user.getAps() >= current.getAps()) {
                                                                    temp[tempSize] = requirements[i];
                                                                    tempSize++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    } else if ((user.getOpt1Choice().equals(current.getOpt3Choice())) || current.getOpt3Choice().equals("any")) {
                                        if (user.getOpt1Mark() >= current.getOpt3Mark()) {

                                            if ((user.getOpt2Choice().equals(current.getOpt1Choice())) || current.getOpt1Choice().equals("any")) {
                                                if (user.getOpt2Mark() >= current.getOpt1Mark()) {
                                                    if ((user.getOpt3Choice().equals(current.getOpt2Choice())) || current.getOpt2Choice().equals("any")) {
                                                        if (user.getOpt3Mark() >= current.getOpt2Mark()) {
                                                            //312
                                                            if (user.getLo() >= 50) {
                                                                if (user.getAps() >= current.getAps()) {
                                                                    temp[tempSize] = requirements[i];
                                                                    tempSize++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // If the user has met the requirement for at least 1 degree:
        if (tempSize != 0) {
            // Create a new output integer array, with size being equal to that of the temporary array
            int[] output = new int[tempSize];
            // Get the ID of every degree in the temporary array and add it to the output array
            for (int i = 0; i < tempSize; i++) {
                output[i] = temp[i].getID();
            }
            // Return the array
            return output;
        } else { // Otherwise
            // Return nothing
            return null;
        }
    }

    /**
     * For a degree's dedicated tab, this method converts the degree's
     * requirement into a readable format
     *
     * @param req The Requirement Object to convert
     * @return The requirement as a readable format
     */
    public String toString(Requirement req) {
        String output = "";

        output += "Required APS:\t\t" + req.getAps();
        output += "\n\n";
        output += "Required Subjects:\n";

        if (req.getHlChoice().equals("eng")) {
            output += "English HL:\t\t" + req.getHlMark() + "%\n";
        }
        if (req.getFalChoice().equals("eng")) {
            output += "English FAL:\t\t" + req.getFalMark() + "%\n";
        }
        if (req.getMathChoice().equals("cor")) {
            output += "Core Mathematics:\t" + req.getMathMark() + "%\n";
        } else if (req.getMathChoice().equals("lit")) {
            output += "Mathematical Literacy:\t" + req.getMathMark() + "%\n";
        } else if (req.getFalChoice().equals("tec")) {
            output += "Technical Mathematics:\t" + req.getMathMark() + "%\n";
        }
        if (!req.getOpt1Choice().equals("any")) {
            output += getSubject(req.getOpt1Choice()) + ":\t" + req.getOpt1Mark() + "%\n";
        }
        if (!req.getOpt2Choice().equals("any")) {
            output += getSubject(req.getOpt2Choice()) + ":\t" + req.getOpt2Mark() + "%\n";
        }
        if (!req.getOpt3Choice().equals("any")) {
            output += getSubject(req.getOpt3Choice()) + ":\t" + req.getOpt3Mark() + "%\n";
        }

        return output;
    }

    /**
     * Return the requirement belonging to a specific degree
     *
     * @param degreeID The ID of the Degree to use
     * @return The Requirement belonging to the Degree
     */
    public Requirement getReqWithDegID(int degreeID) {
        // For each requirement in the class's array (Skip user marks, which is in the first entry of the array)
        for (int i = 1; i < size + 1; i++) {
            // If a match is found:
            if (requirements[i].getDeg().getDegreeID() == degreeID) {
                // Return the Requirement object
                return requirements[i];
            }
        } // Otherwise
        // Return nothing
        return null;
    }
}
