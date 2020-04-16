package com.company.model.animal;

public class Invertebrate extends Animal {
    private int legs;

    public Invertebrate() {
    }
    public Invertebrate(String name, String scientificName, int legs) {
        super(name, scientificName);
        this.legs = legs;
    }

    // Get
    public int getLegs() {
        return legs;
    }

    // Set
    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return getScientificName() + " (" + getName() + ") and have " + legs + " legs";
    }

    @Override
    public String toCSV() {
        return getName() + "," + getScientificName() + "," + getLegs() + "";
    }
}
