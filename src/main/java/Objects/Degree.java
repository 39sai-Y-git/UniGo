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
// This class represents the Degree Object
public class Degree {

    // FIELDS
    private int degreeID;
    private String name;
    private University uni;
    private Faculty fac;
    private String desc;

    // CONSTRUCTOR
    /**
     * Instantiate a new Degree Object
     *
     * @param degreeID
     * @param name
     * @param uni
     * @param fac
     * @param desc
     */
    public Degree(int degreeID, String name, University uni, Faculty fac, String desc) {
        this.degreeID = degreeID;
        this.name = name;
        this.uni = uni;
        this.fac = fac;
        this.desc = desc;
    }

    // GETTERS & SETTERS
    public int getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUni() {
        return uni;
    }

    public void setUni(University uni) {
        this.uni = uni;
    }

    public Faculty getFac() {
        return fac;
    }

    public void setFac(Faculty fac) {
        this.fac = fac;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
