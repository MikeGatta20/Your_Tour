package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import com.techelevator.security.jwt.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin

public class CityTourController {


    private final LandmarkDao landmarkDao ;
    @Autowired
    public CityTourController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @RequestMapping(path = "/search/name/{name}", method = RequestMethod.GET)
    public List<Landmark> Landmark(@PathVariable String name) {

        return landmarkDao.getLandmarkByName(name);
    }

    @RequestMapping(path = "/search/category/{category}", method = RequestMethod.GET)
    public List<Landmark> Category(@PathVariable String category) {

        return landmarkDao.getLandmarkByCategory(category);
    }
    @RequestMapping(path = "/search/allLandmarks", method = RequestMethod.GET)
    public List<Map<String, Object>> allLandmarks () {
        List<Landmark> allLandmarks = landmarkDao.getAllLandmarks();
        List<Map<String, Object>> landmarksWithSchedules = new ArrayList<>();
        // extract out
        int i = 1;
        for (Landmark landmark : allLandmarks) {
            landmark.setLandmarkId(i);
            ArrayList<Schedule> schedules = landmarkDao.getSchedulesForLandmark(landmark.getLandmarkId());
            Map<String, Object> landmarkMap = new HashMap<>();
            landmarkMap.put("landmark", landmark);
            landmarkMap.put("schedule", schedules);
            landmarksWithSchedules.add(landmarkMap);
            i++;

        }

        return landmarksWithSchedules;
    }

    @RequestMapping(path = "/search/availableHours/{open_time}/{close_time}/{day_of_week}", method = RequestMethod.GET)
    public List<Landmark> availableHours(
            @PathVariable("open_time") LocalTime openTime,
            @PathVariable("close_time") LocalTime closeTime,
            @PathVariable("day_of_week") String dayOfWeek
    ) {
        return landmarkDao.getAvailableHours(openTime, closeTime, dayOfWeek);
    }
}

