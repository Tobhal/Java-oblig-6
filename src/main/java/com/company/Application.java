package com.company;

import com.company.reposity.ObservationRepositoryCSV;
import com.company.reposity.ObservationRepositoryJSON;

public class Application {
    public static void main(String[] args) {
        ObservationRepositoryCSV observationRepositoryCSV = new ObservationRepositoryCSV("observation");
        ObservationRepositoryJSON observationRepositoryJSON = new ObservationRepositoryJSON("observation");


    }
}
/*

 */