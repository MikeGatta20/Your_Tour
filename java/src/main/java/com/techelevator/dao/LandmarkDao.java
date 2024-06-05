package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.ArrayList;
import java.util.List;

public interface LandmarkDao {

    ArrayList<Landmark> getLandmarkByName(String name);

    ArrayList<Landmark> getLandmarkByCategory(String category);

    //Landmark getLandmarkByAvailability(String availableHours);List<Landmark> get
    ArrayList<Landmark> getAllLandmarks();
}
