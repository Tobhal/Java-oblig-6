package com.company.model.planetSystem;

import java.util.ArrayList;

public class PlanetSystem {
    private String name, pichureUrl;
    private Star star;
    private ArrayList<Planet> planets = new ArrayList<>();

    public PlanetSystem() {
    }
    public PlanetSystem(String name, String pichureUrl, Star star) {
        this.name = name;
        this.pichureUrl = pichureUrl;
        this.star = star;
    }
    public PlanetSystem(String name, String pichureUrl, Star star, ArrayList<Planet> planets) {
        this.name = name;
        this.pichureUrl = pichureUrl;
        this.star = star;
        this.planets = planets;
    }

    // Get
    public String getName() {
        return name;
    }
    public String getPichureUrl() {
        return pichureUrl;
    }
    public Star getStar() {
        return star;
    }
    public ArrayList<Planet> getPlanets() {
        return planets;
    }
    public Planet getPlanet(String planetString) {
        for (Planet planet : planets)
            if (planet.getName().equalsIgnoreCase(planetString))
                return planet;

        return null;
    }

    // Set
    public void setName(String name) {
        this.name = name;
    }
    public void setPichureUrl(String pichureUrl) {
        this.pichureUrl = pichureUrl;
    }
    public void setStar(Star star) {
        this.star = star;
    }
    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public void addPlanet(Planet planet){
        planets.add(planet);
    }

    @Override
    public String toString() {
        return "Planet System " + name + " has the star: " + star.getName() + "and the planets: \n\t" + planets;
    }
}
