package com.company.model.animal;

public class Invertebrate extends Animal {
    private int legs;

    public Invertebrate() {
    }
    public Invertebrate(String name, String scientificName, int legs) {
        super(name, scientificName);
        this.legs = legs;
    }

    //Get
    public int getLegs() {
        return legs;
    }

    //Set
    public void setLegs(int legs) {
        this.legs = legs;
    }

    //Update
    public void update(Invertebrate newInvertebrate) {
        super.update(newInvertebrate);
        setLegs(newInvertebrate.getLegs());
    }

    public void setProp(String prop, String value) {
        switch (prop.toLowerCase()) {
            case "name":
            case "animal_name":
                setName(value);
                break;
            case "scientificname":
            case "animal_scientificname":
                setScientificName(value);
                break;
            case "mod":
            case "animal_mod":
                setLegs(Integer.parseInt(value));
                break;
        }
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
