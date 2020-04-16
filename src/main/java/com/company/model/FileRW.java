package com.company.model;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileRW {
    private FileTypes fileTypes;
    private String csvDevider = ",";

    public enum FileTypes {
        CSV,
        JSON
    }

    public static void read(File file, List<Observation> observationList, FileTypes fileType) {
        switch (fileType) {
            case CSV:
                //Read file CSV

                break;
            case JSON:
                //Read file JSON

                break;
        }
    }

    public static void write(String savePath, Map<String, Observation> observationMap, FileTypes fileType) throws IOException {
        switch (fileType) {
            case CSV:
                //Read file CSV
                //TODO:Add planet Moon?
                try(FileWriter fileWriter = new FileWriter(new File(savePath + (savePath.contains(".csv") ? "" : ".csv")))) {
                    fileWriter.write(new Observation().toCSVFormat());

                    for (Observation observation : observationMap.values()) {
                        fileWriter.write("\n");
                        fileWriter.write(observation.toCSV());
                    }
                }
                break;
            case JSON:
                //Read file JSON
                ObjectMapper mapper = new ObjectMapper();
                ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
                writer.writeValue(new File(savePath + (savePath.contains(".json") ? "" : ".json")), observationMap);
                break;
        }
    }
}
