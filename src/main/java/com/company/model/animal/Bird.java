package com.company.model.animal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bird extends Animal {
    private boolean canFly;

    public Bird() {
    }
    public Bird(String name, String scientificName, boolean canFly) {
        super(name, scientificName);
        this.canFly = canFly;
    }

    //Get
    @JsonProperty
    public boolean canFly() {
        return canFly;
    }

    //Set
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    //Update
    public void update(Bird newBird) {
        super.update(newBird);
        setCanFly(newBird.canFly());
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
                setCanFly(Boolean.parseBoolean(value));
                break;
        }
    }

    @Override
    public String toString() {
        return getScientificName() + " (" + getName() + ") " + (canFly ? "can fly" : "can't fly");
    }

    @Override
    public String toCSV() {
        return getName() + "," + getScientificName() + "," + canFly + "";
    }
}
