package com.company.reposity;

import com.company.model.Location;
import com.company.model.Observation;
import com.company.model.animal.Animal;
import com.company.model.planetSystem.Planet;

import java.util.ArrayList;

public interface IObservationRepository {

    //Read
    ArrayList<Observation> getAllObservations();
    ArrayList<Location> getAllLocations();
    ArrayList<Animal> getAllAnimals();
    ArrayList<Planet> getAllPlanets();


    Observation getObservation(String name);
    Observation getObservation(int id);

    Location getLocation(Observation observation);

    Animal getAnimal(Observation observation);
    Animal getAnimal(Location location);

    Planet getPlanet(String name);
    Planet getPlanet(Observation observation);
    Planet getPlanet(Location location);

    //Create
    void createObservation(Observation observation);

    void createLocation(Location location);

    void createAnimal(Animal animal);

    void createPlanet(Planet planet);

    //Update
    void updateObservation(Observation observation);

    void updateLocation(Location location);

    void updateAnimal(Animal animal);

    void updatePlanet(Planet planet);

    //Delete
    void deleteObservation(Observation observation);

    void deleteLocation(Location location);

    void deleteAnimal(Animal animal);

    void deletePlanet(Planet planet);

}

/*
TODO: Add Read
TODO: Add Create
TODO: Add Update
TODO: Add Delete
*/