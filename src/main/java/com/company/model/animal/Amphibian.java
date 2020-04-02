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

    // Get
    public Groups getGroup() {
        return group;
    }

    // Set
    public void setGroup(Groups group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return getScientificName() + " (" + getName() + ") is part of the group " + group;
    }
}
