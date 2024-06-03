package com.techelevator.model;

public class Address {

    private String streetName;
    private int houseNumber;
    private int zipCode;
    private String city;
    private String state;


    public Address (String streetName, int houseNumber, int zipCode, String city, String state) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
