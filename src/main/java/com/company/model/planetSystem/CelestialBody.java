package com.company.model.planetSystem;

public abstract class CelestialBody {
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

    // Get
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

    // Set
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