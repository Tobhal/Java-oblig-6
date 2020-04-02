package com.company.model.planetSystem;

import org.jetbrains.annotations.NotNull;

public abstract class NaturalSatellite extends CelestialBody implements Comparable<NaturalSatellite>{
    private double semiMajorAxis, eccentricity, orbitalPeriod;
    private CelestialBody centrealCelestialBody;

    public NaturalSatellite(){
    }
    public NaturalSatellite(String name) {
        super(name);
    }
    public NaturalSatellite(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        super(name, pictureUrl, radius, mass);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
    }
    public NaturalSatellite(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centrealCelestialBody) {
        super(name, pictureUrl, radius, mass);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centrealCelestialBody = centrealCelestialBody;
    }



    // Get
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    public double getEccentricity() {
        return eccentricity;
    }
    public CelestialBody getCentrealCelestialBody() {
        return centrealCelestialBody;
    }

    // Set
    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }
    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }
    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }
    public void setCentrealCelestialBody(CelestialBody centrealCelestialBody) {
        this.centrealCelestialBody = centrealCelestialBody;
    }

    @Override
    public String toString() {
        return getName() + " has mass " + getMass() + ", radius " + getRadius() + ", semi major axis " + semiMajorAxis + ", eccentricity " + eccentricity + " and orbital period " + orbitalPeriod + " and it spins around " + centrealCelestialBody.getName() + "\n";
    }

    @Override
    public int compareTo(@NotNull NaturalSatellite otherNaturalSatellite) {
        return (int)getSemiMajorAxis() - (int)otherNaturalSatellite.getSemiMajorAxis();
    }
}
