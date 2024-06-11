package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Landmark;
import com.techelevator.model.Ratings;
import com.techelevator.model.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;

@Component
public class JdbcLandmarkDao implements LandmarkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArrayList<Landmark> getLandmarkByName(String name) {
        String sql = "SELECT landmark_name, category, description, open_time, close_time, day_of_week, distance, address, landmark_image FROM landmarks " +
                "JOIN schedule \n" +
                "ON schedule.landmark_id = landmarks.landmark_id \n" +
                "WHERE landmark_name ILIKE ?; ";

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
    public ArrayList<Landmark> getLandmarkByCategory(String category) {
        String sql = "SELECT landmark_name, category, description, open_time, close_time, day_of_week, distance, address, landmark_image FROM landmarks " +
                "JOIN schedule \n" +
                "ON schedule.landmark_id = landmarks.landmark_id \n" +
                "WHERE category ILIKE ?; ";

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

    @Override
    public ArrayList<Landmark> getAllLandmarks() {
        String sql = "SELECT landmark_name, category, description, distance, address, landmark_image FROM landmarks";


        ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

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
    public ArrayList<Landmark> getAvailableHours(LocalTime openTime, LocalTime closeTime, String day) {
        String sql = "SELECT landmark_name, category, description, open_time, close_time, day_of_week, distance, address, landmark_image " +
                "FROM landmarks " +
                "JOIN schedule ON schedule.landmark_id = landmarks.landmark_id " +
                "WHERE open_time <= ? AND close_time >= ? AND day_of_week = ?";

        ArrayList<Landmark> landmarks = new ArrayList<>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, openTime, closeTime, day);
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
    public ArrayList<Schedule> getSchedulesForLandmark(int landmarkId) {
        String sql = "SELECT * FROM schedule WHERE landmark_id = ?";

        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkId);

            while (results.next()) {
                Schedule schedule = mapRowToSchedule(results);
                schedules.add(schedule);
            }
        } catch (NullPointerException e) {
            throw new DaoException("NullPointerException", e);
        }

        return schedules;
    }

    @Override
    public ArrayList<Ratings> getAllRatings() {
        String sql = "SELECT  landmark_id, SUM (thumbs_up) AS total_thumbs_up,SUM (thumbs_down) AS total_thumbs_down\n" +
                "FROM landmark_ratings\n" +
                "GROUP BY landmark_id; ";
        ArrayList<Ratings> ratings = new ArrayList<>();
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Ratings rating = mapRowToRatings(results);
                ratings.add(rating);
            }
        } catch (NullPointerException e) {
            throw new DaoException("NullPointerException", e);
        }

        return ratings;
    }

    @Override
    public Ratings updateRating(Ratings rating) {
        String sql = "INSERT INTO landmark_ratings (user_id, landmark_id, thumbs_up, thumbs_down)\n" +
        "VALUES (?, ?, ?, ?)\n" +
        "ON CONFLICT (user_id, landmark_id) DO UPDATE SET thumbs_up = EXCLUDED.thumbs_up, thumbs_down = EXCLUDED.thumbs_down;";
        try {
            int rowsUpdated = jdbcTemplate.update(sql, rating.getUser_id(), rating.getLandmark_id(), rating.getThumbs_up(), rating.getThumbs_down());


        } catch (NullPointerException e) {
            throw new DaoException("NullPointerException", e);
        }
        return rating;
    }

    private Schedule mapRowToSchedule(SqlRowSet results) {
        Schedule schedule = new Schedule();
        schedule.setOpenTime(results.getTime("open_time").toLocalTime());
        schedule.setCloseTime(results.getTime("close_time").toLocalTime());
        schedule.setDayOfWeek(results.getString("day_of_week"));
        schedule.setLandmarkId(results.getInt("landmark_id"));

        return schedule;
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
        landmark.setLandmarkImage(results.getString("landmark_image"));





        return landmark;

    }
    public Ratings mapRowToRatings(SqlRowSet results){
        Ratings rating = new Ratings();
        rating.setLandmark_id((results.getInt("landmark_id")));
        rating.setThumbs_up((results.getInt("total_thumbs_up")));
        rating.setThumbs_down((results.getInt("total_thumbs_down")));

        return rating;
    }



}
