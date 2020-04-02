package com.company.model.planetSystem;

public class Star extends CelestialBody {
    private double effectivetemprature;

    public Star() {
    }
    public Star(String name, String pictureUrl, double radius, double mass, double effectivetemprature) {
        super(name, pictureUrl, radius, mass);
        this.effectivetemprature = effectivetemprature;
    }

    // Get
    public double getEffectivetemprature() {
        return effectivetemprature;
    }

    // Set
    public void setEffectivetemprature(double effectivetemprature) {
        this.effectivetemprature = effectivetemprature;
    }

    @Override
    public String toString() {
        return getName() + " has mass " + getMass() + ", radius " + getRadius() + " and a effective temperature " + effectivetemprature;
    }
}
