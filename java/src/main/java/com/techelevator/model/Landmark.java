package com.techelevator.model;

public class Landmark {

    private int landmarkId;
    private String landmarkName;

    private String streetName;
    private int houseNumber;
    private int zipCode;
    private String city;
    private String stateName;
    private String availableHours;
    private String category;
    private String description;
    private String landmarkImage;
    private Double distance;

    public Landmark(int landmarkId, String landmarkName, String streetName, int houseNumber, int zipCode, String city, String stateName, String availableHours, String category, String description, String landmarkImage, Double distance) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.stateName = stateName;
        this.zipCode = zipCode;
        this.availableHours = availableHours;
        this.category = category;
        this.description = description;
        this.landmarkImage = landmarkImage;
        this.distance = distance;
    }

    public Landmark() {

    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
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
        return stateName;
    }

    public void setState(String state) {
        this.stateName = stateName;
    }

    public String getAvailability() {
        return availableHours;
    }

    public void setAvailability(String availability) {
        this.availableHours = availableHours;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return landmarkImage;
    }

    public void setImages(String images) {
        this.landmarkImage = landmarkImage;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
