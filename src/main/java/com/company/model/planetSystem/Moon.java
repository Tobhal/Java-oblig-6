package com.company.model.planetSystem;

import org.jetbrains.annotations.NotNull;

public class Moon extends NaturalSatellite{

    public Moon() {
    }
    public Moon(String name){
        super(name);
    }
    public Moon(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centrealCelestialBody) {
        super(name, pictureUrl, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod, centrealCelestialBody);
    }
}
