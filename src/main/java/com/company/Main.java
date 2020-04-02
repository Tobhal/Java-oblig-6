package com.company;

import com.company.model.Location;
import com.company.model.Observation;
import com.company.model.animal.*;
import com.company.model.planetSystem.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Observation> observations = new HashMap<>();

        Amphibian amphibian = new Amphibian("Spring Toads", "Bufo bufo", com.company.model.animal.Amphibian.Groups.AMPHIBIA);
        Bird bird = new Bird("dove", "Aves", true);
        Invertebrate invertebrate = new Invertebrate("Langust", "Palinurus elephas", 6);


        Planet planet = new Planet("Earth", "image", 6371, 5.972E+24, 1, 0.017, 365);
        Planet planet1 = new Planet("Earth", "image", 5000, 5.972E+24, 0.1, 0.017, 365);
        Star star = new Star("Star", "image", 1234567, 7654321, 123);
        Moon moon = new Moon("Moon", "image", 1737.0, 55057387086.9752, 0.0, 0.0, 0.0, planet);

        planet.setCentrealCelestialBody(star);
        planet.addMoon(moon);
        planet1.setCentrealCelestialBody(star);
        planet1.addMoon(moon);


        PlanetSystem planetSystem = new PlanetSystem("Solar system", "", star);
        planetSystem.addPlanet(planet);
        planetSystem.addPlanet(planet1);



        Location location = new Location(1234.567, 7654.321, planet);
        location.addBiome(Location.Biome.DESERT);
        location.addBiome(Location.Biome.TUNDRA);

        Observation observation = new Observation(100, "The first", "image", "The best comment!!", amphibian, location, LocalDate.now());

        observations.put(observation.getName(), observation);

        /*
        System.out.println("--------------------");
        System.out.println(observation);
        System.out.println("--------------------");
        System.out.println(planet);
        System.out.println("--------------------");
        System.out.println(amphibian);
        System.out.println(bird);
        System.out.println(invertebrate);
        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println(planetSystem);
        */

        System.out.println(planetSystem);
        System.out.println("-----");
        planetSystem.getPlanets().sort(Planet::compareTo);
        System.out.println(planetSystem);

    }
}
/*


Sorting old things:
    planetSystem.getPlanets().sort(Planet::compareTo);
    planetSystem.getPlanets().sort((Planet planet11, Planet planet12) -> planet11.compareTo(planet12));
    planetSystem.getPlanets().sort((Planet planet11, Planet planet12) -> planet11.getName().compareToIgnoreCase(planet12.getName()));
 */