package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.ArrayList;
import java.util.List;

public interface LandmarkDao {

    ArrayList<Landmark> getLandmarkByName(String name);

    List<Landmark> getLandmarkByCategory(String category);

    //Landmark getLandmarkByAvailability(String availableHours);


}
