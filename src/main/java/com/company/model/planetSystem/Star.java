package com.company.model.planetSystem;

public class Star extends CelestialBody {
    private double effectiveTemperature;
    //Temperature

    public Star() {
    }
    public Star(String name, String pictureUrl, double radius, double mass, double effectiveTemperature) {
        super(name, pictureUrl, radius, mass);
        this.effectiveTemperature = effectiveTemperature;
    }

    // Get
    public double getEffectiveTemperature() {
        return effectiveTemperature;
    }

    // Set
    public void setEffectiveTemperature(double effectiveTemperature) {
        this.effectiveTemperature = effectiveTemperature;
    }

    @Override
    public String toString() {
        return getName() + " has mass " + getMass() + ", radius " + getRadius() + " and a effective temperature " + effectiveTemperature;
    }

    public String toCSV() {
        return getName() + "," + getRadius() + "," + getMass() + "," + getEffectiveTemperature();
    }

    public static String toCSVFormat() {
        return "Planet_Star_name,Planet_Star_radius,Planet_Star_mass,Planet_Star_effectiveTemperature,";
    }
}
