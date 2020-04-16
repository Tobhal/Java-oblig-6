package com.company.model.planetSystem;

import org.jetbrains.annotations.NotNull;

public class Moon extends NaturalSatellite{

    public Moon() {
    }
    public Moon(String name){
        super(name);
    }
    public Moon(String name, String pictureUrl, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        super(name, pictureUrl, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod);
    }

    @Override
    public void setProp(String prop, String value) {
        switch (prop.toLowerCase()) {
            case "name":
            case "moon_name":
                setName(value);
                break;
            case "radius":
            case "moon_radius":
                setRadius(Double.parseDouble(value));
                break;
            case "mass":
            case "moon_mass":
                setMass(Double.parseDouble(value));
                break;
            case "semimajoraxis":
            case "moon_semimajoraxis":
                setSemiMajorAxis(Double.parseDouble(value));
                break;
            case "eccentricity":
            case "moon_eccentricity":
                setEccentricity(Double.parseDouble(value));
                break;
            case "orbitalperiod":
            case "moon_orbitalperiod":
                setOrbitalPeriod(Double.parseDouble(value));
                break;
            case "pichureUrl":
            case "moon_pichureUrl":
                setPictureUrl(value);
        }
    }
}
