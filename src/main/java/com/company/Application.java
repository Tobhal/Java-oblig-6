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

        Javalin app = Javalin.create().start();
        app.config.enableWebjars();
        app.before("/", ctx -> ctx.redirect("/observations"));

        //Pages
        app.get("/observations", new VueComponent("observations-overview"));
        app.get("/observations/new", new VueComponent("new-observation"));

        app.get("/observations/:observation-name", new VueComponent("observations-detail"));
        app.get("/observations/:observation-name/update", new VueComponent("update-observation"));
        app.get("/observations/:observation-name/animal", new VueComponent("animal-detail"));




        //Controller
        ObservationController observationController = new ObservationController(new ObservationRepositoryJSON("observation_save"));

        //API
        app.get("/api/observations", ctx -> observationController.getObservations(ctx));
        //app.get("api/observation", observationController::getObservations);
        app.post("/api/observations/new", ctx -> observationController.createObservation(ctx));


        app.get("/api/animals", ctx -> observationController.getAnimals(ctx));
        app.get("/api/locations", ctx -> observationController.getLocations(ctx));
        app.get("/api/planets", ctx -> observationController.getPlanets(ctx));


        app.get("/api/observations/:observation-name", ctx -> observationController.getObservation(ctx));
        app.get("/api/observations/:observation-name/animal", ctx -> observationController.getAnimal(ctx));

        app.post("/api/observations/:observation-name/update", ctx -> observationController.updateObservation(ctx));
        app.get("/api/observations/:observation-name/delete", ctx -> observationController.deleteObservation(ctx));





    }
}
/*

 */