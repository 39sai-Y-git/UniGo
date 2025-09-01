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
// This class represents the Requirement Object
public class Requirement {

    // FIELDS
    private int ID;
    private Degree deg;
    private int hlMark;
    private String hlChoice;
    private int falMark;
    private String falChoice;
    private int mathMark;
    private String mathChoice;
    private int opt1Mark;
    private String opt1Choice;
    private int opt2Mark;
    private String opt2Choice;
    private int opt3Mark;
    private String opt3Choice;
    private int lo;
    private int aps;

    // CONSTRUCTOR
    public Requirement(int ID, Degree deg, int hlMark, String hlChoice, int falMark, String falChoice, int mathMark, String mathChoice, int opt1Mark, String opt1Choice, int opt2Mark, String opt2Choice, int opt3Mark, String opt3Choice, int lo, int aps) {
        this.ID = ID;
        this.deg = deg;
        this.hlMark = hlMark;
        this.hlChoice = hlChoice;
        this.falMark = falMark;
        this.falChoice = falChoice;
        this.mathMark = mathMark;
        this.mathChoice = mathChoice;
        this.opt1Mark = opt1Mark;
        this.opt1Choice = opt1Choice;
        this.opt2Mark = opt2Mark;
        this.opt2Choice = opt2Choice;
        this.opt3Mark = opt3Mark;
        this.opt3Choice = opt3Choice;
        this.lo = lo;
        this.aps = aps;
    }

    // GETTERS & SETTERS
    public Degree getDeg() {
        return deg;
    }

    public void setDeg(Degree deg) {
        this.deg = deg;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHlMark() {
        return hlMark;
    }

    public void setHlMark(int hlMark) {
        this.hlMark = hlMark;
    }

    public String getHlChoice() {
        return hlChoice;
    }

    public void setHlChoice(String hlChoice) {
        this.hlChoice = hlChoice;
    }

    public int getFalMark() {
        return falMark;
    }

    public void setFalMark(int falMark) {
        this.falMark = falMark;
    }

    public String getFalChoice() {
        return falChoice;
    }

    public void setFalChoice(String falChoice) {
        this.falChoice = falChoice;
    }

    public int getMathMark() {
        return mathMark;
    }

    public void setMathMark(int mathMark) {
        this.mathMark = mathMark;
    }

    public String getMathChoice() {
        return mathChoice;
    }

    public void setMathChoice(String mathChoice) {
        this.mathChoice = mathChoice;
    }

    public int getOpt1Mark() {
        return opt1Mark;
    }

    public void setOpt1Mark(int opt1Mark) {
        this.opt1Mark = opt1Mark;
    }

    public String getOpt1Choice() {
        return opt1Choice;
    }

    public void setOpt1Choice(String opt1Choice) {
        this.opt1Choice = opt1Choice;
    }

    public int getOpt2Mark() {
        return opt2Mark;
    }

    public void setOpt2Mark(int opt2Mark) {
        this.opt2Mark = opt2Mark;
    }

    public String getOpt2Choice() {
        return opt2Choice;
    }

    public void setOpt2Choice(String opt2Choice) {
        this.opt2Choice = opt2Choice;
    }

    public int getOpt3Mark() {
        return opt3Mark;
    }

    public void setOpt3Mark(int opt3Mark) {
        this.opt3Mark = opt3Mark;
    }

    public String getOpt3Choice() {
        return opt3Choice;
    }

    public void setOpt3Choice(String opt3Choice) {
        this.opt3Choice = opt3Choice;
    }

    public int getLo() {
        return lo;
    }

    public void setLo(int lo) {
        this.lo = lo;
    }

    public int getAps() {
        return aps;
    }

    public void setAps(int aps) {
        this.aps = aps;
    }
}
