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

        //Controller
        ObservationController observationController = new ObservationController(new ObservationRepositoryJSON("observation"));

        //API
        app.get("/api/observations", ctx -> observationController.getObservations(ctx));
        //app.get("api/observation", observationController::getObservations);
    }
}
/*

 */