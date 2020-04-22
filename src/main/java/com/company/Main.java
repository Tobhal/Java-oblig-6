package com.company;

import com.company.model.FileRW;
import com.company.model.Location;
import com.company.model.Observation;
import com.company.model.animal.*;
import com.company.model.planetSystem.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Observation> observations = new HashMap<>();
        HashMap<String, Observation> observationsFromFile = new HashMap<>();

        //Planets generation
        Star arcturus = new Star("Arcturus", "", 7.75E5, 2.27E30, 5500);
        Star rigel = new Star("Rigel", "", 2.72E5, 5.58E29, 2600);

        PlanetSystem foxzarIII = new PlanetSystem("Foxzar III", "", arcturus);
        PlanetSystem blabenuzar = new PlanetSystem("Blabenuzar", "", rigel);

        Planet hian = new Planet("Hian", "", 18858, 1.767712E25, 1.8, 0.5, 2900, arcturus);
        Planet ichohasu = new Planet("Ichohasu", "", 1433475, 1.3437E27, 4.6, 0.8, 33215, arcturus);
        Planet whuthadusky = new Planet("Whuthadusky", "", 10066, 9.43576E24, 0.7, 0.2,269, rigel);
        Planet hund = new Planet("Hind", "", 10002, 9.37604E24, 0.9, 0.5, 720, rigel);

        hian.addMoon(new Moon("Whiteeele"));
        hian.addMoon(new Moon("Ladmi"));

        ichohasu.addMoon(new Moon("Arl"));
        ichohasu.addMoon(new Moon("Rumope"));

        hund.addMoon(new Moon("Lint"));
        hund.addMoon(new Moon("Ehvonvo"));
        hund.addMoon(new Moon("Asna"));

        foxzarIII.addPlanet(hian);
        foxzarIII.addPlanet(ichohasu);
        blabenuzar.addPlanet(whuthadusky);
        blabenuzar.addPlanet(hund);


        // Animal generation
        Amphibian springToad = new Amphibian("Spring Toads", "Bufo bufo", Amphibian.Groups.AMPHIBIA);
        Amphibian okapi = new Amphibian("Overluxurious okapi", "Abalistes sarsii", Amphibian.Groups.REPTILIA);
        Amphibian eel = new Amphibian("Easternmost eel", "Norops tessellata", Amphibian.Groups.MAMMALIA);

        Bird dove = new Bird("Dove", "Aves", true);
        Bird urus = new Bird("Unagrarian urus", "Cephaloscyllium sculptus", false);

        Invertebrate langust = new Invertebrate("Langust", "Palinurus elephas", 6);
        Invertebrate eidolonhelvum = new Invertebrate("Ethologic eidolonhelvum", "Astropecten jamaicensis", 50);


        //Observation generation
        Observation bufoBufoObservation = new Observation(100, "Bufo bufo observation", springToad, new Location(-13.55729, 4.74894,
                new ArrayList<Location.Biome>() {{add(Location.Biome.FRESHWATER); add(Location.Biome.GRASSLAND); add(Location.Biome.FOREST);}}, hian), LocalDate.parse("2339-04-01"), "", "They look like toads, did someone take some with them from Earth?");

        Observation okapiObservation = new Observation(5, "Abalistes sarsii observation", okapi, new Location(24.96709, 61.64084,
                new ArrayList<Location.Biome>() {{add(Location.Biome.DESERT);}}, hian), LocalDate.parse("2340-11-07"), "", "They look like a weird reptilian.");

        Observation eelObservation = new Observation(80, "Norops tessellata observation", eel, new Location(11.37629, 45.09165,
                new ArrayList<Location.Biome>() {{add(Location.Biome.TUNDRA); add(Location.Biome.FOREST);}}, ichohasu), LocalDate.parse("2339-05-03"), "", "I am not sure what i am looking at...");

        Observation doveObservation = new Observation(26, "Aves observation", dove, new Location( -50.25423, 139.12402,
                new ArrayList<Location.Biome>() {{add(Location.Biome.GRASSLAND);}}, ichohasu), LocalDate.parse("2339-05-03"), "", "I think someone have taken with them 26 doves from Earth.");

        Observation urusObservation = new Observation(229, "Cephaloscyllium sculptus observation", urus, new Location( 79.16069, 91.23182,
                new ArrayList<Location.Biome>() {{add(Location.Biome.GRASSLAND);}}, hund), LocalDate.parse("2339-05-03"), "", "They look like normal birds. The only problem is that i have just seen then for 500m.");

        Observation langustObservation = new Observation(85, "Palinurus elephas observation", langust, new Location( -50.22222, -55.90941,
                new ArrayList<Location.Biome>() {{add(Location.Biome.MARINE); add(Location.Biome.FRESHWATER); add(Location.Biome.GRASSLAND); add(Location.Biome.FOREST);}}, whuthadusky), LocalDate.parse("2340-09-10"), "", "They have some figure on the back that kan look like a elephant.");

        Observation eidolonhelvumObservation = new Observation(3000, "Astropecten jamaicensis observation", eidolonhelvum, new Location( -26.00161,  -60.65475,
                new ArrayList<Location.Biome>() {{add(Location.Biome.GRASSLAND); add(Location.Biome.FOREST); add(Location.Biome.DESERT); add(Location.Biome.TUNDRA); add(Location.Biome.FRESHWATER);}}, whuthadusky), LocalDate.parse("2338-01-13"), "", "It is hard to say how many i have found, because I can se the all over the place.");


        observations.put(springToad.getScientificName(), bufoBufoObservation);
        observations.put(okapi.getScientificName(), okapiObservation);
        observations.put(eel.getScientificName(), eelObservation);
        observations.put(dove.getScientificName(), doveObservation);
        observations.put(urus.getScientificName(), urusObservation);
        observations.put(langust.getScientificName(), langustObservation);
        observations.put(eidolonhelvum.getScientificName(), eidolonhelvumObservation);

        System.out.println(observations);


        //Saving to file
        FileRW.write("Observation", observations, FileRW.FileTypes.CSV);
        FileRW.write("Observation", observations, FileRW.FileTypes.JSON);

        //Read from file
       // FileRW.read("Observation", observationsFromFile, FileRW.FileTypes.CSV);
       // FileRW.read("Observation", observationsFromFile, FileRW.FileTypes.JSON);

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


        System.out.println(planetSystem);
        System.out.println("-----");
        planetSystem.getPlanets().sort(Planet::compareTo);
        System.out.println(planetSystem);
        */
    }
}
/*


Sorting old things:
    planetSystem.getPlanets().sort(Planet::compareTo);
    planetSystem.getPlanets().sort((Planet planet11, Planet planet12) -> planet11.compareTo(planet12));
    planetSystem.getPlanets().sort((Planet planet11, Planet planet12) -> planet11.getName().compareToIgnoreCase(planet12.getName()));
 */