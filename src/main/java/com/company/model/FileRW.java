package com.company.model;

import com.company.model.animal.Amphibian;
import com.company.model.animal.Animal;
import com.company.model.animal.Bird;
import com.company.model.animal.Invertebrate;
import com.company.model.planetSystem.Planet;
import com.company.model.planetSystem.Star;
import com.fasterxml.jackson.databind.*;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class FileRW {
    public enum FileTypes {
        CSV,
        JSON
    }

    public static void read(String filePath, Map<String, Observation> observationMap, FileTypes fileType) {
        File file;
        ArrayList<Observation> observations = new ArrayList<>();
        switch (fileType) {
            case CSV:
                //Read from file CSV
                file = new File((filePath.contains("CSV/") ? "" : "CSV/") + filePath + (filePath.contains(".csv") ? "" : ".csv"));
                String csvDevider = ",";

                try (Scanner fileScanner = new Scanner(file)) {
                    String[] prop = fileScanner.nextLine().split(csvDevider);

                    while (fileScanner.hasNext()) {
                        String[] splitString = fileScanner.nextLine().split(csvDevider);

                        Star star = new Star();
                        for (int i = 0; i < splitString.length; i++) {
                            if (prop[i].toLowerCase().startsWith("star_"))
                                star.setProp(prop[i], splitString[i]);
                        }

                        Planet planet = new Planet();
                        for (int i = 0; i < splitString.length; i++) {
                            if (prop[i].toLowerCase().startsWith("planet_"))
                                planet.setProp(prop[i], splitString[i]);
                        }
                        planet.setStar(star);

                        Location location = new Location();
                        for (int i = 0; i < splitString.length; i++) {
                            if (prop[i].toLowerCase().startsWith("location_"))
                                location.setProp(prop[i], splitString[i]);
                        }
                        location.setPlanet(planet);

                        Animal animal;
                        switch (splitString[6].toLowerCase()) {
                            case "invertebrate":
                                animal = new Invertebrate();
                                for (int i = 0; i < splitString.length; i++) {
                                    if (prop[i].toLowerCase().startsWith("animal_"))
                                        animal.setProp(prop[i], splitString[i]);
                                }
                                break;
                            case "amphibian":
                                animal = new Amphibian();
                                for (int i = 0; i < splitString.length; i++) {
                                    if (prop[i].toLowerCase().startsWith("animal_"))
                                        animal.setProp(prop[i], splitString[i]);
                                }
                                break;
                            case "bird":
                                animal = new Bird();
                                for (int i = 0; i < splitString.length; i++) {
                                    if (prop[i].toLowerCase().startsWith("animal_"))
                                        animal.setProp(prop[i], splitString[i]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + splitString[6].toLowerCase());
                        }

                        Observation observation = new Observation();
                        for (int i = 0; i < splitString.length; i++) {
                            if (!(prop[i].toLowerCase().contains("_"))) {
                                observation.setProp(prop[i], splitString[i]);
                            }
                        }
                        observation.setAnimal(animal);
                        observation.setLocation(location);

                        observationMap.put(animal.getScientificName(), observation);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                break;
            case JSON:
                //Read from file JSON
                file = new File((filePath.contains("JSON/") ? "" : "JSON/") + filePath + (filePath.contains(".json") ? "" : ".json"));

                ObjectMapper mapper = new ObjectMapper();
                Observation[] observations1 = new Observation[0];

                try {
                    observations1 = mapper.readValue(file, Observation[].class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                observations.addAll(Arrays.asList(observations1));

                for (Observation observation : observations) {
                    observationMap.put(observation.getAnimal().getScientificName(), observation);
                }
                break;
        }
    }

    public static void write(String savePath, Map<String, Observation> observationMap, FileTypes fileType) throws IOException {
        switch (fileType) {
            case CSV:
                //Write to file CSV
                //TODO:Add planet Moon?
                try(FileWriter fileWriter = new FileWriter(new File((savePath.contains("CSV/") ? "" : "CSV/") + savePath + (savePath.contains(".csv") ? "" : ".csv")))) {
                    fileWriter.write(new Observation().toCSVFormat());

                    for (Observation observation : observationMap.values()) {
                        fileWriter.write("\n");
                        fileWriter.write(observation.toCSV());
                    }
                }
                break;
            case JSON:
                //Write to file JSON
                ObjectMapper mapper = new ObjectMapper();
                ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
                writer.writeValue(new File((savePath.contains("JSON/") ? "" : "JSON/") + savePath + (savePath.contains(".json") ? "" : ".json")), new ArrayList<>(observationMap.values()));
                break;
        }
    }
}
