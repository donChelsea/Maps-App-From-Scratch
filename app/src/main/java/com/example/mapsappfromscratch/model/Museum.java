package com.example.mapsappfromscratch.model;

public class Museum {
    private String name;
    private String address;

    public Museum() {}

    public Museum(String name, String address, String city, String state, String zip) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
