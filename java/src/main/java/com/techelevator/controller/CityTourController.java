package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import com.techelevator.model.LoginDto;
import com.techelevator.model.LoginResponseDto;
import com.techelevator.model.User;
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
import java.util.List;

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
}

