package com.samil.androidmapapp;

public class Data {

    int id;
    String name;
    String information;
    String description;

    public Data(String name, String information, String description) {
        this.name = name;
        this.information = information; //ilçe
        this.description = description; //mahalle
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
