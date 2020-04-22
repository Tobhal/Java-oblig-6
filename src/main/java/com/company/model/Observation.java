package com.company.model;

import com.company.model.animal.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.naming.Name;
import java.time.LocalDate;
import java.util.List;

public class Observation implements ICSVRead{
    private static int idAll;
    private int id, quantity;
    private String name, image, comment;
    private Animal animal;
    private LocalDate date;
    private Location location;

    public Observation(){
        idAll++;
        this.id = idAll;
    }
    public Observation(String name, Location location) {
        this.name = name;
        this.location = location;
    }
    public Observation(int quantity, String name, Animal animal, Location location, LocalDate date, String image, String comment) {
        idAll++;
        this.id = idAll;
        this.quantity = quantity;
        this.name = name;
        this.image = image;
        this.comment = comment;
        this.animal = animal;
        this.location = location;
        this.date = date;
    }

    //Get
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

    //Sett
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

    //Update
    public void update(Observation newObservation) {
        if (newObservation.getId() != 0)
            setId(newObservation.getId());

        if (newObservation.getQuantity() != 0)
            setQuantity(newObservation.getQuantity());

        if (newObservation.getName() != null)
            setName(newObservation.getName());

        if (newObservation.getImage() != null)
            setImage(newObservation.getImage());

        if (newObservation.getComment() != null)
            setComment(newObservation.getComment());

        if (newObservation.getAnimal() != null)
            setAnimal(newObservation.getAnimal());

        if (newObservation.getLocation() != null) {
            Location location = getLocation();
            location.update(newObservation.getLocation());
        }

        if (newObservation.getDate() != null)
            setDate(newObservation.getDate());
    }


    @Override
    public String toString() {
        return "\nObservation (" + name + " (id:" + id + ")) was done " + date + " at location:\n\t" +
                location + "\n" +
                "on the animal: " + (animal == null ? "" : animal.getName()) + "\n" +
                "Comment:\n" + comment + "\n\n";
    }

    public String toCSV() {
        return id + "," + name + "," + quantity + "," +
                animal.toCSV() + "," + animal.getClass().getSimpleName() + "," +
                location.toCSV() + "," + date + "," +
                image + "," + getLocation().getPlanet().getPictureUrl() + "," + getLocation().getPlanet().getStar().getPictureUrl() + "," + comment;
    }

    public static String toCSVFormat() {
        return "ID,Name,Quantity," + new Bird().toCSVFormat() + new Location().toCSVFormat() + "Date,Image,Planet_Image,Star_image,Comment";
    }

    @Override
    public void setProp(String prop, String value) {
        switch (prop.toLowerCase()) {
            case "id":
                setId(Integer.parseInt(value));
                break;
            case "name":
                setName(value);
                break;
            case "quantity":
                setQuantity(Integer.parseInt(value));
                break;
            case "date":
                setDate(LocalDate.parse(value));
                break;
            case "image":
                setImage(value);
                break;
            case "comment":
                setComment(value);
        }
    }
}
