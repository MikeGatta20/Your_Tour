package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLandmarkDao implements LandmarkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArrayList<Landmark> getLandmarkByName(String name) {
        String sql = "SELECT landmark_name, category, description, distance, address FROM landmarks WHERE landmark_name ILIKE ?; ";

        ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");

            while (results.next()) {
                Landmark landmark = mapRowToLandmark(results);

                landmarks.add(landmark);
            }
        } catch (NullPointerException e) {
            throw new DaoException("NullPointerException", e);
        }

        return landmarks;
    }

    @Override
    public List<Landmark> getLandmarkByCategory(String category) {
        String sql = "SELECT landmark_name, category, description, distance, address FROM landmarks WHERE category ILIKE ?; ";

        ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + category + "%");

            while (results.next()) {
                Landmark landmark = mapRowToLandmark(results);
                landmarks.add(landmark);
            }
        } catch (NullPointerException e) {
            throw new DaoException("NullPointerException", e);
        }

        return landmarks;
    }

    public Landmark mapRowToLandmark(SqlRowSet results){
        /*
        name
        description
        available days/hours
        venue type
        images
        distance from starting point

        */
        Landmark landmark = new Landmark();
        landmark.setLandmarkName(results.getString("landmark_name"));
        landmark.setCategory(results.getString("category"));
        landmark.setDescription(results.getString("description"));
        landmark.setDistance(results.getDouble("distance"));
        landmark.setAddress(results.getString("address"));

        return landmark;

    }


}
