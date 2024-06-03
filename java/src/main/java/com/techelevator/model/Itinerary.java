package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Itinerary {

    private int itineraryId;
    private String name;
    private String startingLocation;

    private LocalDate date;
    private LocalTime time;

    public Itinerary(int itineraryId, String name, String startingLocation, LocalDate date,LocalTime time) {
        this.itineraryId = itineraryId;
        this.name = name;
        this.startingLocation = startingLocation;
        this.date = date;
        this.time=time;
    }

    public Itinerary() {

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

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
