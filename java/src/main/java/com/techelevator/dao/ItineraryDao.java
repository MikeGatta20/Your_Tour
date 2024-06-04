package com.techelevator.dao;

import com.techelevator.model.Itinerary;

import java.util.List;

public interface ItineraryDao {

    List<Itinerary> getItineraries();



  Itinerary getMyItinerary(int itineraryId);
  Itinerary createItinerary(Itinerary itinerary);
  Itinerary updateItinerary(Itinerary itinerary);
  List<Itinerary> getItinerariesByUserId(int userId);
  Itinerary createItineraryByUserId(int userId, Itinerary itinerary);

  //Itinerary getItineraryByUserId(Itinerary itinerary);
 // Itinerary deleteItineraryById( Itinerary itinerary);



}
