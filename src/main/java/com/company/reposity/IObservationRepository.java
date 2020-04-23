package com.company.reposity;

import com.company.model.FileRW;
import com.company.model.Location;
import com.company.model.Observation;
import com.company.model.animal.Animal;
import com.company.model.planetSystem.Planet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public interface IObservationRepository {
    //Read
    ArrayList<Observation> getAllObservations();
    HashMap<String, Observation> getAllObservationHash();
    ArrayList<Location> getAllLocations();
    ArrayList<Animal> getAllAnimals();
    ArrayList<Planet> getAllPlanets();

    Observation getObservation(String name);
    Observation getObservation(int id);

    Planet getPlanet(String name);
    Planet getPlanet(Observation observation);
    Planet getPlanet(Location location);

    //Create
    void createObservation(Observation observation);
    void createLocation(Observation observation, Location location);
    void createAnimal(Observation observation, Animal animal);
    void createPlanet(Location location, Planet planet);

    //Update
    void updateObservation(Observation observation, Observation newObservation);
    void updateLocation(Location location, Location newLocation);
    void updateAnimal(Animal animal, Animal newAnimal);
    void updatePlanet(Planet planet, Planet newPlanet);

    //Delete
    void deleteObservation(String observationName);

    void save(FileRW.FileTypes fileType);
    void read(String fileName, HashMap<String, Observation> observationHashMap, FileRW.FileTypes fileType);
}