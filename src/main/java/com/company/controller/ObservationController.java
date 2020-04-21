package com.company.controller;

import com.company.reposity.IObservationRepository;
import io.javalin.http.Context;

public class ObservationController {
    private IObservationRepository observationRepository;

    public ObservationController(IObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public void getObservations(Context context) {
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

    public void deleteObservation(Context context) {
        String observationName = context.pathParam("observation-name");
        observationRepository.deleteObservation(observationName);
    }

    public void createObservation(Context context) {

    }

    public void updateObservation(Context context) {

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
