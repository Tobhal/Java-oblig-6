package com.company.model.planetSystem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Planet extends NaturalSatellite {
    private ArrayList<Moon> moons = new ArrayList<>();
    private Star star;

    public Planet(){
    }
    public Planet(String name) {
        super(name);
    }
    public Planet(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        super(name, pictureUrl, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod);
    }
    public Planet(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, Star star) {
        super(name, pictureUrl, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod);
        this.star = star;
    }
    public Planet(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, Star star, ArrayList<Moon> moons) {
        super(name, pictureUrl, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod);
        this.star = star;
        this.moons = moons;
    }

    //Get
    public ArrayList<Moon> getMoons() {
        return moons;
    }
    public Star getStar() {
        return star;
    }

    //Set
    public void setMoons(ArrayList<Moon> moons) {
        this.moons = moons;
    }
    public void setStar(Star star) {
        this.star = star;
    }

    public void addMoon(Moon moon) {
        moons.add(moon);
    }
    public void addMoons(ArrayList<Moon> moonArrayList) {
        this.moons.addAll(moonArrayList);
    }

    //Update
    public void update(Planet newPlanet) {
        super.update(newPlanet);
        setMoons(newPlanet.getMoons());
        setStar(newPlanet.getStar());
    }

    @Override
    public String toString() {
        return getName() + " has mass " + getMass() + ", radius " + getRadius() + ", semi major axis " + getSemiMajorAxis() + ", eccentricity " + getEccentricity() + " and orbital period " + getOrbitalPeriod() + ".\n\t\t" +
                "It spins around " + star.getName() + "\n\t\t" +
                (moons != null ? "and had the moons: " + moons : "");
    }

    public String toCSV() {
        return getName() + "," + getRadius() + "," + getMass() + "," + getSemiMajorAxis() + "," + getEccentricity() + "," + getOrbitalPeriod() + "," + star.toCSV();
    }

    public static String toCSVFormat() {
        return "Planet_name,Planet_radius,Planet_mass,Planet_semiMajorAxis,Planet_eccentricity,Planet_orbitalPeriod," + new Star().toCSVFormat();
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
            case "semimajoraxis":
            case "planet_semimajoraxis":
                setSemiMajorAxis(Double.parseDouble(value));
                break;
            case "eccentricity":
            case "planet_eccentricity":
                setEccentricity(Double.parseDouble(value));
                break;
            case "orbitalperiod":
            case "planet_orbitalperiod":
                setOrbitalPeriod(Double.parseDouble(value));
                break;
            case "pichureUrl":
            case "planet_pichureUrl":
                setPictureUrl(value);
                break;
            case "star":
            case "planet_star":
                break;
        }
    }
}
