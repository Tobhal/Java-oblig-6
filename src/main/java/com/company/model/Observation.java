package com.company.model;

import com.company.model.animal.*;

import javax.naming.Name;
import java.time.LocalDate;

public class Observation {
    private static int idAll;
    private int id, quantity;
    private String name, image, comment;
    private Animal animal;
    private Location location;
    private LocalDate date;

    public Observation(){
    }
    public Observation(int quantity, String name, Animal animal, Location location, LocalDate date, String image, String comment) {
        this.id = idAll;
        idAll++;
        this.quantity = quantity;
        this.name = name;
        this.image = image;
        this.comment = comment;
        this.animal = animal;
        this.location = location;
        this.date = date;
    }

    // Get
    public int getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }
    public String getComment() {
        return comment;
    }
    public Animal getAnimal() {
        return animal;
    }
    public Location getLocation() {
        return location;
    }
    public LocalDate getDate() {
        return date;
    }

    // Sett
    public void setId(int id) {
        this.id = id;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "\nObservation (" + name + " (id:" + id + ")) was done " + date + " at location:\n\t" +
                location + "\n" +
                "on the animal: " + animal.getName() + "\n" +
                "Comment:\n" + comment + "\n\n";
    }

    public String toCSV() {
        return id + "," + name + "," + quantity + "," +
                animal.toCSV() + "," + animal.getClass().getSimpleName() + "," +
                location.toCSV() + "," + date + "," +
                image + "," + getLocation().getPlanet().getPictureUrl() + "," + getLocation().getPlanet().getStar().getPictureUrl() + "," + comment;
    }

    public static String toCSVFormat() {
        return "ID,Name,Quantity," + new Bird().toCSVFormat() + new Location().toCSVFormat() + "Date,Image,Planet_Image,Planet_Star_image,Comment";
    }
}
