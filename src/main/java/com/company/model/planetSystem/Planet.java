package com.company.model.planetSystem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Planet extends NaturalSatellite {
    private ArrayList<Moon> moons = new ArrayList<>();

    public Planet(){
    }
    public Planet(String name) {
        super(name);
    }
    public Planet(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        super(name, pictureUrl, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod);
    }
    public Planet(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centrealCelestialBody) {
        super(name, pictureUrl, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod, centrealCelestialBody);
    }
    public Planet(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centrealCelestialBody, ArrayList<Moon> moons) {
        super(name, pictureUrl, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod, centrealCelestialBody);
        this.moons = moons;
    }

    // Get
    public ArrayList<Moon> getMoons() {
        return moons;
    }

    // Set
    public void setMoons(ArrayList<Moon> moons) {
        this.moons = moons;
    }

    public void addMoon(Moon moon) {
        moons.add(moon);
    }
    public void addMoons(ArrayList<Moon> moonArrayList) {
        this.moons.addAll(moonArrayList);
    }

    @Override
    public String toString() {
        return getName() + " has mass " + getMass() + ", radius " + getRadius() + ", semi major axis " + getSemiMajorAxis() + ", eccentricity " + getEccentricity() + " and orbital period " + getOrbitalPeriod() + ".\n\t\t" +
                "It spins around " + getCentrealCelestialBody().getName() + "\n\t\t" +
                (moons != null ? "and had the moons: " + moons : "");
    }

}
