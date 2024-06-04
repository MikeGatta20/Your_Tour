package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class JdbcLandmarkDao implements LandmarkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArrayList<Landmark> getLandmarkByName(String name) {
        String sql = "SELECT landmark_name FROM landmarks WHERE landmark_name ILIKE ?";

        ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");

            while (results.next()) {
                Landmark landmark = new Landmark();

                landmark.setLandmarkName(results.getString("landmark_name"));

                landmarks.add(landmark);
            }
        } catch (NullPointerException e) {
            throw new DaoException("NullPointerException", e);
        }

        return landmarks;
    }



}
