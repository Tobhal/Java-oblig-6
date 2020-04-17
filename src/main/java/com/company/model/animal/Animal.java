package com.company.model.animal;

import com.company.model.ICSVRead;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Amphibian.class, name = "amphibian"),
        @JsonSubTypes.Type(value = Bird.class, name = "bird"),
        @JsonSubTypes.Type(value = Invertebrate.class, name = "invertebrate")
})


public abstract class Animal implements ICSVRead {
    private String name;
    private String scientificName;

    public Animal() {
    }
    public Animal(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }

    //Get
    public String getName() {
        return name;
    }
    public String getScientificName() {
        return scientificName;
    }

    //Set
    public void setName(String name) {
        this.name = name;
    }
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    //Update
    public void update(Animal newAnimal) {
        setName(newAnimal.getName());
        setScientificName(newAnimal.getScientificName());
    }

    public String toCSV() {
        return name + "," + scientificName + "";
    }

    public static String toCSVFormat() {
        return "Animal_name,Animal_scientificName,Animal_mod,Animal_type,";
    }
}
