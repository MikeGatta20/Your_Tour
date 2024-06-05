package com.techelevator.model;

import java.time.LocalTime;

public class Schedule {
    private LocalTime openTime;
    private LocalTime closeTime;
    private String dayOfWeek;

    private int landmarkId;

    public Schedule(LocalTime openTime, LocalTime closeTime, String dayOfWeek, int landmarkId) {
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.dayOfWeek = dayOfWeek;
        this.landmarkId = landmarkId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public Schedule() {

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
