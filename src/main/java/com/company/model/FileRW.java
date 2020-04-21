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
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

                    int animalTypeIndex = -1;

                    for (int i = 0; i < prop.length; i++) {
                        switch (prop[i].toLowerCase()) {
                            case "animal_type":
                                animalTypeIndex = i;
                                break;
                        }
                    }

                    while (fileScanner.hasNext()) {
                        String[] splitString = fileScanner.nextLine().split(csvDevider);

                        //Creates a empty class so i can add things to it later
                        Star star = new Star();
                        Planet planet = new Planet();
                        Location location = new Location();
                        Animal animal = null;
                        Observation observation = new Observation();

                        if (!(animalTypeIndex == -1)) {
                            switch (splitString[animalTypeIndex].toLowerCase()) {     //Setts the correct animal type
                                case "invertebrate":
                                    animal = new Invertebrate();
                                    break;
                                case "amphibian":
                                    animal = new Amphibian();
                                    break;
                                case "bird":
                                    animal = new Bird();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + splitString[6].toLowerCase());
                            }
                        }

                        //Adds values to the correct class in a more dynamic way
                        for (int i = 0; i < prop.length; i++) {
                            if (prop[i].toLowerCase().startsWith("star_"))
                                star.setProp(prop[i], splitString[i]);
                            else if (prop[i].toLowerCase().startsWith("planet_"))
                                planet.setProp(prop[i], splitString[i]);
                            else if (prop[i].toLowerCase().startsWith("location_"))
                                location.setProp(prop[i], splitString[i]);
                            else if (prop[i].toLowerCase().startsWith("animal_")) {
                                assert animal != null;
                                animal.setProp(prop[i], splitString[i]);
                            }
                            else if (!(prop[i].toLowerCase().contains("_"))) {
                                observation.setProp(prop[i], splitString[i]);
                            }
                        }

                        //Handle comments with comma
                        if (prop.length < splitString.length) {
                            StringBuilder stringBuilder = new StringBuilder();

                            for (int i = prop.length - 1; i < splitString.length; i++) {
                                stringBuilder.append(splitString[i]);
                                if (i == splitString.length - 1) {
                                    stringBuilder.append("");
                                } else {
                                    stringBuilder.append(",");
                                }
                            }

                            observation.setComment(stringBuilder.toString());
                        }

                        planet.setStar(star);
                        location.setPlanet(planet);
                        observation.setAnimal(animal);
                        observation.setLocation(location);

                        observationMap.put(observation.getName(), observation);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                break;
            case JSON:
                //Read from file JSON
                file = new File((filePath.contains("JSON/") ? "" : "JSON/") + filePath + (filePath.contains(".json") ? "" : ".json"));

                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                Observation[] observations1 = new Observation[0];

                try {
                    observations1 = mapper.readValue(file, Observation[].class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                observations.addAll(Arrays.asList(observations1));

                for (Observation observation : observations) {
                    observationMap.put(observation.getName(), observation);
                }
                break;
        }
    }

    public static void write(String savePath, Map<String, Observation> observationMap, FileTypes fileType) {
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case JSON:
                //Write to file JSON
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
                try {
                    writer.writeValue(new File((savePath.contains("JSON/") ? "" : "JSON/") + savePath + (savePath.contains(".json") ? "" : ".json")), new ArrayList<>(observationMap.values()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public static boolean canReadWrite(String fileName, FileTypes fileType) {
        Boolean canReadWrite = true;
        File file;

        switch (fileType) {
            case CSV:
                canReadWrite = new File((fileName.contains("CSV/") ? "" : "CSV/") + fileName + (fileName.contains(".csv") ? "" : ".csv")).exists();
                break;
            case JSON:
                canReadWrite = new File((fileName.contains("JSON/") ? "" : "JSON/") + fileName + (fileName.contains(".json") ? "" : ".json")).exists();
                break;
            default:
                canReadWrite = false;
        }
        return canReadWrite;
    }
}
