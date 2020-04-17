package com.company.model.planetSystem;

import com.company.model.ICSVRead;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Star.class, name = "star")
})

public abstract class CelestialBody implements ICSVRead {
    private String name, pictureUrl;
    private double radius, mass;

    public CelestialBody() {
    }
    public CelestialBody(String name) {
        this.name = name;
    }
    public CelestialBody(String name, String pictureUrl, double radius, double mass) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.radius = radius;
        this.mass = mass;
    }

    //Get
    public String getName() {
        return name;
    }
    public double getRadius() {
        return radius;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
    public double getMass() {
        return mass;
    }

    //Set
    public void setName(String name) {
        this.name = name;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    //Update
    public void update(CelestialBody newCelestialBody) {
        setName(newCelestialBody.getName());
        setRadius(newCelestialBody.getRadius());
        setMass(newCelestialBody.getMass());
        setPictureUrl(newCelestialBody.getPictureUrl());
    }

    @Override
    public String toString() {
        return "CelestialBody{" +
                "name = '" + name + '\'' +
                ", pictureUrl = '" + pictureUrl + '\'' +
                ", radius = " + radius +
                ", mass = " + mass +
                '}';
    }
}
