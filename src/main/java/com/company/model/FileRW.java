package com.company.model;

public class FileRW {
    private FileTypes fileTypes;
    private String csvDevider;

    public enum FileTypes {
        CSV,
        JSON
    }
}
