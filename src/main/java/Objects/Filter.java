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

import Managers.UniManager;

/**
 *
 * @author Saien Naidu
 */
public class Filter {
    private final UniManager um = new UniManager();
    
    private boolean useMarks;
    
    private boolean kzn;
    private boolean gauteng;
    private boolean eastcape;
    private boolean westcape;
    private boolean freestate;
    private boolean northwest;
    private boolean mpumalanga;
    private boolean limpopo;
    
    private boolean commerce;
    private boolean engineering;
    private boolean health;
    private boolean law;
    private boolean humanities;
    private boolean sciences;
    
    private String uni1;
    private String uni2;
    private String uni3;
    
    private boolean include;
    private boolean exclude;

    public Filter(boolean useMarks, boolean kzn, boolean gauteng, boolean eastcape, boolean westcape, boolean freestate, boolean northwest, boolean mpumalanga, boolean limpopo, boolean commerce, boolean engineering, boolean health, boolean law, boolean humanities, boolean sciences, String uni1, String uni2, String uni3, boolean include, boolean exclude) {
        this.useMarks = useMarks;
        this.kzn = kzn;
        this.gauteng = gauteng;
        this.eastcape = eastcape;
        this.westcape = westcape;
        this.freestate = freestate;
        this.northwest = northwest;
        this.mpumalanga = mpumalanga;
        this.limpopo = limpopo;
        this.commerce = commerce;
        this.engineering = engineering;
        this.health = health;
        this.law = law;
        this.humanities = humanities;
        this.sciences = sciences;
        this.uni1 = uni1;
        this.uni2 = uni2;
        this.uni3 = uni3;
        this.include = include;
        this.exclude = exclude;
    }

    public boolean isUseMarks() {
        return useMarks;
    }

    public void setUseMarks(boolean useMarks) {
        this.useMarks = useMarks;
    }

    public boolean isKzn() {
        return kzn;
    }

    public void setKzn(boolean kzn) {
        this.kzn = kzn;
    }

    public boolean isGauteng() {
        return gauteng;
    }

    public void setGauteng(boolean gauteng) {
        this.gauteng = gauteng;
    }

    public boolean isEastcape() {
        return eastcape;
    }

    public void setEastcape(boolean eastcape) {
        this.eastcape = eastcape;
    }

    public boolean isWestcape() {
        return westcape;
    }

    public void setWestcape(boolean westcape) {
        this.westcape = westcape;
    }

    public boolean isFreestate() {
        return freestate;
    }

    public void setFreestate(boolean freestate) {
        this.freestate = freestate;
    }

    public boolean isNorthwest() {
        return northwest;
    }

    public void setNorthwest(boolean northwest) {
        this.northwest = northwest;
    }

    public boolean isMpumalanga() {
        return mpumalanga;
    }

    public void setMpumalanga(boolean mpumalanga) {
        this.mpumalanga = mpumalanga;
    }

    public boolean isLimpopo() {
        return limpopo;
    }

    public void setLimpopo(boolean limpopo) {
        this.limpopo = limpopo;
    }

    public boolean isCommerce() {
        return commerce;
    }

    public void setCommerce(boolean commerce) {
        this.commerce = commerce;
    }

    public boolean isEngineering() {
        return engineering;
    }

    public void setEngineering(boolean engineering) {
        this.engineering = engineering;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public boolean isLaw() {
        return law;
    }

    public void setLaw(boolean law) {
        this.law = law;
    }

    public boolean isHumanities() {
        return humanities;
    }

    public void setHumanities(boolean humanities) {
        this.humanities = humanities;
    }

    public boolean isSciences() {
        return sciences;
    }

    public void setSciences(boolean sciences) {
        this.sciences = sciences;
    }

    public String getUni1() {
        return uni1;
    }

    public void setUni1(String uni1) {
        this.uni1 = uni1;
    }

    public String getUni2() {
        return uni2;
    }

    public void setUni2(String uni2) {
        this.uni2 = uni2;
    }

    public String getUni3() {
        return uni3;
    }

    public void setUni3(String uni3) {
        this.uni3 = uni3;
    }

    public boolean isInclude() {
        return include;
    }

    public void setInclude(boolean include) {
        this.include = include;
    }

    public boolean isExclude() {
        return exclude;
    }

    public void setExclude(boolean exclude) {
        this.exclude = exclude;
    }
    
}
