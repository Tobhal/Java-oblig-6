package com.company.controller;

import com.company.model.FileRW;
import com.company.model.Location;
import com.company.model.Observation;
import com.company.model.animal.*;
import com.company.model.planetSystem.Planet;
import com.company.reposity.IObservationRepository;
import io.javalin.http.Context;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ObservationController {
    private IObservationRepository observationRepository;

    public ObservationController(IObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public void getObservations(Context context) {
        //observationRepository.read("Observation_save", observationRepository.getAllObservationHash(), FileRW.FileTypes.JSON);
        context.json(observationRepository.getAllObservations());
    }


    public void getObservation(Context context) {
        String observationName = context.pathParam("observation-name");

        context.json(observationRepository.getObservation(observationName));
    }

    public void getAnimal(Context context) {
        String observationName = context.pathParam("observation-name");
        context.json(observationRepository.getObservation(observationName).getAnimal());
    }

    public void getLocation(Context context) {
        String observationName = context.pathParam("observation-name");
        context.json(observationRepository.getObservation(observationName).getLocation());
    }

    public void getDate(Context context) {
        String observationName = context.pathParam("observation-name");
        context.json(observationRepository.getObservation(observationName).getDate());
    }

    public void getPlanet(Context context) {
        String observationName = context.pathParam("observation-name");
        context.json(observationRepository.getObservation(observationName).getLocation().getPlanet());
    }

    public void deleteObservation(Context context) {
        String observationName = context.pathParam("observation-name");
        observationRepository.deleteObservation(observationName);
        context.redirect("/observations");
    }

    public void createObservation(Context context) {
        // Observation
        String name = context.formParam("name");
        int quantity = Integer.parseInt(Objects.requireNonNull(context.formParam("quantity")));
        String dateS = context.formParam("theDate");
        String image = context.formParam("image");
        String commnet = context.formParam("comment");

        assert dateS != null;
        LocalDate date = LocalDate.parse(dateS);

        // Animal
        String animalName = context.formParam("animal_name");
        String animalScientificName = context.formParam("animal_scientificName");
        String animalType = context.formParam("animal_type");
        String animalMod = context.formParam("animal_mod");

        Animal animal;

        switch (Objects.requireNonNull(animalType)) {
            case "amphibian":
                animal = new Amphibian(animalName, animalScientificName, Amphibian.Groups.valueOf(animalMod));
                break;
            case "bird":
                boolean animalModBool = false;
                assert animalMod != null;
                if (animalMod.equals("on"))
                    animalModBool = true;

                animal = new Bird(animalName, animalScientificName, animalModBool);
                break;
            case "invertebrate":
                assert animalMod != null;
                animal = new Invertebrate(animalName, animalScientificName, Integer.parseInt(animalMod));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + animalMod);
        }

        // Location
        String locationPlanet = context.formParam("location_planet");
        double locationLongitude = Double.parseDouble(Objects.requireNonNull(context.formParam("location_longitude")));
        double locationLatitude = Double.parseDouble(Objects.requireNonNull(context.formParam("location_latitude")));
        String locationBiomes = Objects.requireNonNull(context.formParam("location_biomes")).toUpperCase();

        Planet planet = observationRepository.getPlanet(locationPlanet);

        Location location = new Location(locationLongitude, locationLatitude,new ArrayList<Location.Biome>(){{add(Location.Biome.valueOf(locationBiomes));}}, planet);

        observationRepository.createObservation(new Observation(quantity, name, animal, location, date, image, commnet));

        observationRepository.save(FileRW.FileTypes.JSON);
        context.redirect("/observations/" + name);
    }

    public void updateObservation(Context context) {
        String originalObservation = context.pathParam("observation-name");

        int quantity = context.formParam("quantity").equals("") ? 0 : Integer.parseInt(context.formParam("quantity"));
        String dateString = context.formParam("theDate").equals("") ? null : context.formParam("theDate");
        String image = context.formParam("image").equals("") ? null : context.formParam("image");
        String comment = context.formParam("comment").equals("") ? null : context.formParam("comment");

        String animalName = context.formParam("animal");

        String locationPlanet = context.formParam("location_planet");
        String locationLatitude = context.formParam("location_latitude").equals("") ? null : context.formParam("location_latitude");
        String locationLongitude = context.formParam("location_longitude").equals("") ? null : context.formParam("location_longitude");
        String locationBiome = context.formParam("location_biome");


        Animal animal = null;
        Location location = null;

        if (animalName != null)
            for (Animal animal1 : observationRepository.getAllAnimals())
                if (animal1.getName().equals(animalName))
                    animal = animal1;
        if (!(locationPlanet == null && locationLatitude == null && locationLongitude == null && locationBiome == null)) {
            location = new Location();
            if (locationPlanet != null)
                location.setPlanet(observationRepository.getPlanet(locationPlanet));
            else
                location.setPlanet(null);

            if (locationLongitude != null)
                location.setLongitude(Double.parseDouble(locationLongitude));
            else
                location.setLongitude(0);

            if (locationLatitude != null)
                location.setLatitude(Double.parseDouble(locationLatitude));
            else
                location.setLatitude(0);

            if (locationBiome != null)
                location.setBiomes(new ArrayList<Location.Biome>(){{add(Location.Biome.valueOf(locationBiome.toUpperCase()));}});
            else
                location.setBiomes(null);
        }

        Observation observation = new Observation(quantity, null, animal, location, (dateString == null ? null : LocalDate.parse(dateString)), image, comment);

        observationRepository.updateObservation(observationRepository.getObservation(originalObservation), observation);
        observationRepository.save(FileRW.FileTypes.JSON);

        context.redirect("/observations/" + context.pathParam("observation-name"));
    }

    public void getAnimals(Context context) {
        context.json(observationRepository.getAllAnimals());
    }

    public void getLocations(Context context) {
        context.json(observationRepository.getAllLocations());
    }

    public void getPlanets(Context context) {
        context.json(observationRepository.getAllPlanets());
    }
}
