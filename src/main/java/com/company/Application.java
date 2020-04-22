package com.company;

import com.company.controller.ObservationController;
import com.company.model.FileRW;
import com.company.reposity.ObservationRepositoryCSV;
import com.company.reposity.ObservationRepositoryJSON;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {
        /*
        ObservationRepositoryCSV observationRepositoryCSV = new ObservationRepositoryCSV("observation");
        ObservationRepositoryJSON observationRepositoryJSON = new ObservationRepositoryJSON("observation");
         */

        String fileName = "observation_save";

        Javalin app = Javalin.create().start();
        app.config.enableWebjars();
        app.before("/", ctx -> ctx.redirect("/observations"));

        //Pages
        app.get("/observations", new VueComponent("observations-overview"));
        app.get("/observations/new", new VueComponent("new-observation"));

        app.get("/observations/:observation-name", new VueComponent("observations-detail"));
        app.get("/observations/:observation-name/update", new VueComponent("update-observation"));
        app.get("/observations/:observation-name/animal", new VueComponent("animal-detail"));
        app.get("/observations/:observation-name/planet", new VueComponent("planet-detail"));

        //Controller
        ObservationController observationController = new ObservationController(new ObservationRepositoryJSON((FileRW.canReadWrite(fileName, FileRW.FileTypes.JSON) ? fileName : "Observation")));

        //API
        app.get("/api/observations", ctx -> observationController.getObservations(ctx));
        //app.get("api/observation", observationController::getObservations);
        app.post("/api/observations/new", ctx -> observationController.createObservation(ctx));


        app.get("/api/animals", ctx -> observationController.getAnimals(ctx));
        app.get("/api/locations", ctx -> observationController.getLocations(ctx));
        app.get("/api/planets", ctx -> observationController.getPlanets(ctx));


        app.get("/api/observations/:observation-name", ctx -> observationController.getObservation(ctx));
        app.get("/api/observations/:observation-name/animal", ctx -> observationController.getAnimal(ctx));
        app.get("/api/observations/:observation-name/planet", ctx -> observationController.getPlanet(ctx));

        app.post("/api/observations/:observation-name/update", ctx -> observationController.updateObservation(ctx));
        app.get("/api/observations/:observation-name/delete", ctx -> observationController.deleteObservation(ctx));





    }
}
/*

 */