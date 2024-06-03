package com.techelevator.dao;

import com.techelevator.model.Itinerary;

import java.util.List;

public interface ItineraryDao {

    List<Itinerary> getItineraries();



  Itinerary getMyItinerary(int itineraryId);
  Itinerary createItinerary(Itinerary itinerary);
  Itinerary updateItinerary(Itinerary itinerary);

  //Itinerary getItineraryByUserId(Itinerary itinerary);
 // Itinerary deleteItineraryById( Itinerary itinerary);



}
