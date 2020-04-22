package com.company.model;

import com.company.model.planetSystem.Planet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Location implements ICSVRead{
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

    //Get
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
    @JsonIgnore
    public String getBiomesCSV() {
        StringBuilder bString = new StringBuilder();
        String prefix = "";
        for (Biome biome : biomes) {
            bString.append(prefix + biome);
            prefix = ";";
        }

        return bString.toString();
    }

    //Set
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

    //Update
    public void update(Location newLocation) {
        if (newLocation.getLatitude() != 0)
            setLongitude(newLocation.getLongitude());
        if (newLocation.getLongitude() != 0)
            setLatitude(newLocation.getLatitude());
        if (newLocation.getPlanet() != null)
            setPlanet(newLocation.getPlanet());
        if (newLocation.getBiomes() != null)
            setBiomes(newLocation.getBiomes());
    }

    @Override
    public String toString() {
        return (planet == null ? "" : planet.getName()) + " (" + latitude + ", " + longitude + ") inside the biomes:" + biomes;
    }

    public String toCSV() {
        return longitude + "," + latitude + "," + getBiomesCSV() + "," + getPlanet().toCSV();
    }

    public static String toCSVFormat() {
        return "Location_longitude,Location_latitude,Location_biomes," + new Planet().toCSVFormat();
    }

    @Override
    public void setProp(String prop, String value) {
        switch (prop.toLowerCase()) {
            case "longitude":
            case "location_longitude":
                setLongitude(Double.parseDouble(value));
                break;
            case "latitude":
            case "location_latitude":
                setLatitude(Double.parseDouble(value));
                break;
            case "biomes":
            case "location_biomes":
                String[] tmp = value.split(";");
                for (String string : tmp) {
                    addBiome(Biome.valueOf(string.toUpperCase()));
                }
                break;
        }
    }
}
