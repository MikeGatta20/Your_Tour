package com.techelevator.model;

import java.time.LocalDateTime;

public class Itinerary {

    private int itineraryId;
    private String name;
    private String startingLocation;

    private LocalDateTime dateTime;

    public Itinerary(int itineraryId, String name, String startingLocation, LocalDateTime dateTime) {
        this.itineraryId = itineraryId;
        this.name = name;
        this.startingLocation = startingLocation;
        this.dateTime = dateTime;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
