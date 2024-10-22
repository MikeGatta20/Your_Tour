package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Landmark {

    private int landmarkId;
    private String landmarkName;

    private String address;

    private String category;
    private String description;
    private String landmarkImage;
    private Double distance;



    public Landmark(int landmarkId, String landmarkName, String address, String category, String description, String landmarkImage, Double distance) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.address = address;
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

    public String getLandmarkImage() {
        return landmarkImage;
    }

    public void setLandmarkImage(String images) {
        this.landmarkImage = images;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
