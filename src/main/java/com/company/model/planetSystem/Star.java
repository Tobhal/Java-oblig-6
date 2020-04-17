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

    //Get
    public double getEffectiveTemperature() {
        return effectiveTemperature;
    }

    //Set
    public void setEffectiveTemperature(double effectiveTemperature) {
        this.effectiveTemperature = effectiveTemperature;
    }

    //Update
    public void update(Star newStar) {
        super.update(newStar);
        setEffectiveTemperature(newStar.getEffectiveTemperature());
    }

    @Override
    public String toString() {
        return getName() + " has mass " + getMass() + ", radius " + getRadius() + " and a effective temperature " + effectiveTemperature;
    }

    public String toCSV() {
        return getName() + "," + getRadius() + "," + getMass() + "," + getEffectiveTemperature();
    }

    public static String toCSVFormat() {
        return "Star_name,Star_radius,Star_mass,Star_effectiveTemperature,";
    }

    @Override
    public void setProp(String prop, String value) {
        switch (prop.toLowerCase()) {
            case "name":
            case "planet_name":
                setName(value);
                break;
            case "radius":
            case "planet_radius":
                setRadius(Double.parseDouble(value));
                break;
            case "mass":
            case "planet_mass":
                setMass(Double.parseDouble(value));
                break;
            case "effectivetemperature":
            case "sun_effectivetemperature":
                setEffectiveTemperature(Double.parseDouble(value));
                break;
            case "image":
            case "star_image":
                setPictureUrl(value);
                break;
        }
    }
}
