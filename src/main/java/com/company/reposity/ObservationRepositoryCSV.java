package com.company.reposity;

import com.company.model.FileRW;
import com.company.model.Location;
import com.company.model.Observation;
import com.company.model.animal.Animal;
import com.company.model.planetSystem.Planet;

import java.util.ArrayList;
import java.util.HashMap;

public class ObservationRepositoryCSV implements IObservationRepository {
    HashMap<String, Observation> observations = new HashMap<>();

    public ObservationRepositoryCSV(String fileName) {
        if (FileRW.canReadWrite(fileName, FileRW.FileTypes.CSV))
            FileRW.read(fileName, observations, FileRW.FileTypes.CSV);
    }

    /*
    Read
     */
    @Override
    public ArrayList<Observation> getAllObservations() {
        ArrayList<Observation> observationArrayList = new ArrayList<>(observations.values());
        observationArrayList.sort((Observation observation1, Observation observation2) -> observation1.getId() - observation2.getId());
        //observationArrayList.sort(Comparator.comparingInt(Observation::getId));

        return observationArrayList;
    }

    @Override
    public HashMap<String, Observation> getAllObservationHash() {
        return null;
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
        ArrayList<String> planets = new ArrayList<>();

        for (Observation observation : observations.values()) {
            if (!planets.contains(observation.getLocation().getPlanet().getName())) {
                planets.add(observation.getLocation().getPlanet().getName());
                planetArrayList.add(observation.getLocation().getPlanet());
            }
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
    public void deleteObservation(String observationName) {
        observations.remove(observationName);
        save(FileRW.FileTypes.CSV);
    }

    //Save
    @Override
    public void save(FileRW.FileTypes fileType) {
        Thread thread = new Thread( () -> {
            FileRW.write("Observation_save", observations, fileType);
        });
        thread.start();
    }

    //Write
    @Override
    public void read(String fileName, HashMap<String, Observation> observationHashMap, FileRW.FileTypes fileType) {

    }
}
