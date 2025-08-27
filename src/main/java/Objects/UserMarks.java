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
public class UserMarks extends Requirement{

    public UserMarks(int hlMark, String hlChoice, int falMark, String falChoice, int mathMark, String mathChoice, int opt1Mark, String opt1Choice, int opt2Mark, String opt2Choice, int opt3Mark, String opt3Choice, int lo) {
        super(0, hlMark, hlChoice, falMark, falChoice, mathMark, mathChoice, opt1Mark, opt1Choice, opt2Mark, opt2Choice, opt3Mark, opt3Choice, lo);
    }
    
    public UserMarks getUserMarks(){
        UserMarks um = new UserMarks(this.getHlMark(), this.getHlChoice(), this.getFalMark(), this.getFalChoice(), this.getMathMark(), this.getMathChoice(), this.getOpt1Mark(), this.getOpt1Choice(), this.getOpt2Mark(), this.getOpt2Choice(), this.getOpt3Mark(), this.getOpt3Choice(), this.getLo());
        return um;
    }
}
