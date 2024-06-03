package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Itinerary;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcItineraryDao implements ItineraryDao{
    private JdbcTemplate template;
    public JdbcItineraryDao(DataSource ds){
        template = new JdbcTemplate(ds);
    }

    @Override
    public List<Itinerary> getItineraries() {
        List<Itinerary> itineraries = new ArrayList<>();
        String sql ="Select itinerary_id,name,starting_location,start_date,start_time"
                     + "FROM itineraries";
        SqlRowSet results = template.queryForRowSet(sql);
        while ((results.next())){
            Itinerary itinerary = mapRowToItinerary(results);
            itineraries.add(itinerary);

            }

        return itineraries;
    }

    @Override
    public Itinerary getMyItinerary(int itineraryId) {
        Itinerary itinerary =  null;
        String sql = "Select itineraries.itinerary_id,name,starting_location,start_date,start_time"
                + "FROM itineraries" +
                "WHERE itineraries.itinerary_id ?" ;

        try {
            SqlRowSet results = template.queryForRowSet(sql, itineraryId);
            if (results.next()) {
                itinerary = mapRowToItinerary(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }


        return itinerary;
    }

    @Override
    public Itinerary createItinerary(Itinerary itinerary) {
        Itinerary newItinerary = null;
        String sql = "INSERT INTO itineraries (name, starting_location, start_date, start_time) values (?, ?, ?, ?) RETURNING itinerary_id";
        try {
            int newItineraryId = template.queryForObject(sql, int.class, itinerary.getName(), itinerary.getStartingLocation(), itinerary.getDate(), itinerary.getTime());
            itinerary.setItineraryId(newItineraryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return itinerary;
    }

    @Override
    public Itinerary updateItinerary(Itinerary itinerary) {
        Itinerary updateItinerary = null;
        String sql = "UPDATE itineraries"+
        "SET name = ?, starting_location = ?, start_date = ?, start_time?" +
                "WHERE itinerary_id = ?;";
        try {
            int newItineraryId = template.queryForObject(sql, int.class, itinerary.getName(), itinerary.getStartingLocation(), itinerary.getDate(), itinerary.getTime());
            if (newItineraryId == 0) {
                throw new DaoException("Zero rows affected, expected at least one.");
            } else {
                updateItinerary = getMyItinerary(itinerary.getItineraryId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }

        return updateItinerary;
    }

    private Itinerary mapRowToItinerary(SqlRowSet results) {
        Itinerary itinerary =new Itinerary();
        itinerary.setItineraryId(results.getInt("itinerary_id"));
        itinerary.setName(results.getString("name"));
        itinerary.setStartingLocation(results.getString("starting_location"));
        itinerary.setDate(results.getDate("date").toLocalDate());
        itinerary.setTime(results.getTime("time").toLocalTime());
        return itinerary;



    }
}



