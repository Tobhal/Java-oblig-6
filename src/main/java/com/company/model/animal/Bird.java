package com.company.model.animal;

public class Bird extends Animal {
    private boolean canFly;

    public Bird() {
    }
    public Bird(String name, String scientificName, boolean canFly) {
        super(name, scientificName);
        this.canFly = canFly;
    }

    // Get
    public boolean CanFly() {
        return canFly;
    }

    // Set
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public String toString() {
        return getScientificName() + " (" + getName() + ") " + (canFly ? "can fly" : "can't fly");
    }
}
