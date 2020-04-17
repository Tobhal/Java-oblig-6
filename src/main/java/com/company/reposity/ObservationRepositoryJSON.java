package com.company.reposity;

import com.company.model.FileRW;
import com.company.model.Location;
import com.company.model.Observation;
import com.company.model.animal.Animal;
import com.company.model.planetSystem.Planet;

import java.util.ArrayList;
import java.util.HashMap;

public class ObservationRepositoryJSON implements IObservationRepository {
    HashMap<String, Observation> observations = new HashMap<>();

    public ObservationRepositoryJSON(String fileName) {
        if (FileRW.canReadWrite(fileName, FileRW.FileTypes.JSON))
            FileRW.read(fileName, observations, FileRW.FileTypes.JSON);
    }

    /*
    Read
     */
    @Override
    public ArrayList<Observation> getAllObservations() {
        return new ArrayList<>(observations.values());
    }

    @Override
    public ArrayList<Location> getAllLocations() {
        ArrayList<Location> locationArrayList = new ArrayList<>();

        for (Observation observation : observations.values()) {
            locationArrayList.add(observation.getLocation());
        }
        return locationArrayList;
    }

    @Override
    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> animalArrayList = new ArrayList<>();

        for (Observation observation : observations.values()) {
            animalArrayList.add(observation.getAnimal());
        }
        return animalArrayList;
    }

    @Override
    public ArrayList<Planet> getAllPlanets() {
        ArrayList<Planet> planetArrayList = new ArrayList<>();

        for (Observation observation : observations.values()) {
            planetArrayList.add(observation.getLocation().getPlanet());
        }
        return planetArrayList;
    }

    @Override
    public Observation getObservation(String name) {
        return observations.get(name);
    }

    @Override
    public Observation getObservation(int id) {
        for (Observation observation : observations.values()) {
            if (observation.getId() == id)
                return observation;
        }
        return null;
    }

    @Override
    public Planet getPlanet(String name) {
        for (Planet planet : getAllPlanets()) {
            if (planet.getName().equals(name))
                return planet;
        }
        return null;
    }

    @Override
    public Planet getPlanet(Observation observation) {
        return observation.getLocation().getPlanet();
    }

    @Override
    public Planet getPlanet(Location location) {
        return location.getPlanet();
    }

    /*
    Create
     */
    @Override
    public void createObservation(Observation observation) {
        observations.put(observation.getAnimal().getScientificName(), observation);
    }

    @Override
    public void createLocation(Observation observation, Location location) {
        observation.setLocation(location);
    }

    @Override
    public void createAnimal(Observation observation, Animal animal) {
        observation.setAnimal(animal);
    }

    @Override
    public void createPlanet(Location location, Planet planet) {
        location.setPlanet(planet);
    }

    /*
    Update
     */
    @Override
    public void updateObservation(Observation observation, Observation newObservation) {
        observation.update(observation);
    }

    @Override
    public void updateLocation(Location location, Location newLocation) {
        location.update(newLocation);
    }

    @Override
    public void updateAnimal(Animal animal, Animal newAnimal) {
        animal.update(newAnimal);
    }

    @Override
    public void updatePlanet(Planet planet, Planet newPlanet) {
        planet.update(newPlanet);
    }

    /*
    Delete
     */
    @Override
    public void deleteObservation(Observation observation) {
        observations.remove(observation.getAnimal().getScientificName());
    }

    @Override
    public void deleteLocation(Location location) {
        for (Observation observation : observations.values()) {
            if (observation.getLocation() == location)
                observation.setLocation(null);
        }
    }

    @Override
    public void deleteAnimal(Animal animal) {
        for (Observation observation : observations.values()) {
            if (observation.getAnimal() == animal)
                observation.setAnimal(null);
        }
    }

    @Override
    public void deletePlanet(Planet planet) {
        for (Observation observation : observations.values()) {
            if (observation.getLocation().getPlanet() == planet)
                observation.getLocation().setPlanet(null);
        }
    }

    //Save
    @Override
    public void saveRepository(FileRW.FileTypes fileType) {
        FileRW.write("Observation_save", observations, fileType);
    }
}
