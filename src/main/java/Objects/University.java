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

/**
 *
 * @author Saien Naidu
 */

// This class represents the University Object

public class University {

    // FIELDS
    private int ID;
    private String name;
    private String desc;
    private String location;
    private int rank;
    private int estb;
    private int students;
    private double accRate;
    
    // CONSTRUCTOR
    public University(int ID, String name, String desc, String location, int rank, int estb, int students, double accRate){
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.location = location;
        this.rank = rank;
        this.estb = estb;
        this.students = students;
        this.accRate = accRate;
    }

    // GETTERS & SETTERS
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getEstb() {
        return estb;
    }

    public void setEstb(int estb) {
        this.estb = estb;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public double getAccRate() {
        return accRate;
    }

    public void setAccRate(double accRate) {
        this.accRate = accRate;
    }
}
