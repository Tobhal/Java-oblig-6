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
}
