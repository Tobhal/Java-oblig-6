package com.company.reposity;

import com.company.model.FileRW;
import com.company.model.Location;
import com.company.model.Observation;
import com.company.model.animal.Animal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ObservationRepositoryJSON implements IObservationRepository {
    HashMap<String, Observation> observations = new HashMap<>();

    public ObservationRepositoryJSON(String fileName) {
        FileRW.read(fileName, observations, FileRW.FileTypes.JSON);
    }


}
