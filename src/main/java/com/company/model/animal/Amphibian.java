package com.company.model.animal;

public class Amphibian extends Animal {
    private Groups group;

    public Amphibian() {
    }
    public Amphibian(String name, String scientificName, Groups group) {
        super(name, scientificName);
        this.group = group;
    }

    public enum Groups {
        AMPHIBIA,
        REPTILIA,
        MAMMALIA
    }

    //Get
    public Groups getGroup() {
        return group;
    }

    //Set
    public void setGroup(Groups group) {
        this.group = group;
    }

    //Update
    public void update(Amphibian newAmphibian) {
        super.update(newAmphibian);
        setGroup(newAmphibian.getGroup());
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
                setGroup(Groups.valueOf(value.toUpperCase()));
                break;
        }
    }

    @Override
    public String toString() {
        return getScientificName() + " (" + getName() + ") is part of the group " + group;
    }

    @Override
    public String toCSV() {
        return getName() + "," + getScientificName() + "," + getGroup() + "";
    }
}
