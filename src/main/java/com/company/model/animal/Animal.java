package com.company.model.animal;

public abstract class Animal {
    private String name;
    private String scientificName;

    public Animal() {
    }
    public Animal(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }

    // Get
    public String getName() {
        return name;
    }
    public String getScientificName() {
        return scientificName;
    }

    // Set
    public void setName(String name) {
        this.name = name;
    }
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
}
