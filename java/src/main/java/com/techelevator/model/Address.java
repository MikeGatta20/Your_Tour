package com.techelevator.model;

public class Address {
    private String streetAddress;
    private String houseNumber;
    private String ZipCode;
    private String city;
    private String state;

    public Address(String streetAddress, String houseNumber, String zipCode, String city, String state) {
        this.streetAddress = streetAddress;
        this.houseNumber = houseNumber;
        ZipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
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
