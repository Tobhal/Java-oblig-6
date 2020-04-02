package com.company.model;

import com.company.model.planetSystem.Planet;
import java.util.ArrayList;

public class Location {
    private double longitude, latitude;
    private ArrayList<Biome> biomes = new ArrayList<>();
    private Planet planet;

    public Location(){
    }
    public Location(double longitude, double latitude, Planet planet) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.planet = planet;
    }
    public Location(double longitude, double latitude, ArrayList<Biome> biomes, Planet planet) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.biomes = biomes;
        this.planet = planet;
    }

    public enum Biome {
        FOREST,
        GRASSLAND,
        FRESHWATER,
        MARINE,
        DESERT,
        TUNDRA
    }

    // Get
    public double getLongitude() {
        return longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public ArrayList<Biome> getBiomes() {
        return biomes;
    }
    public Planet getPlanet() {
        return planet;
    }

    // Set
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setBiomes(ArrayList<Biome> biomes) {
        this.biomes = biomes;
    }
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public void addBiome(Biome biome){
        biomes.add(biome);
    }

    @Override
    public String toString() {
        return planet.getName() + " (" + latitude + ", " + longitude + ") inside the biomes:" + biomes;
    }
}
