package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.ArrayList;

public interface LandmarkDao {

    ArrayList<Landmark> getLandmarkByName(String name);

    //Landmark getLandmarkByAvailability(String availableHours);


}
