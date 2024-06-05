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
    private LocalTime openTime;
    private LocalTime closeTime;
    private String dayOfWeek;


    public Landmark(int landmarkId, String landmarkName, String address, String category, String description, String landmarkImage, Double distance, LocalTime openTime, LocalTime closeTime, String day) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.address = address;
        this.category = category;
        this.description = description;
        this.landmarkImage = landmarkImage;
        this.distance = distance;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.dayOfWeek = dayOfWeek;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
