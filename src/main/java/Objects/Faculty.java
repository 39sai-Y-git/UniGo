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
// This class represents the Faculty Object
public class Faculty {

    // FIELDS
    private int ID;
    private String name;
    private String desc;
    private University uni;

    // CONSTRUCTOR
    /**
     * Instantiate a new Faculty Object
     *
     * @param ID
     * @param name
     * @param desc
     * @param uni
     */
    public Faculty(int ID, String name, String desc, University uni) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.uni = uni;
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

    public University getUni() {
        return uni;
    }

    public void setUni(University uni) {
        this.uni = uni;
    }
}
