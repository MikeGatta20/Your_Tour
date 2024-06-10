package com.techelevator.model;

public class Ratings {

    private int user_id;
    private int landmark_id;
    private int thumbs_up;
    private int thumbs_down;

    public Ratings(int user_id, int landmark_id, int thumbs_up, int thumbs_down) {
        this.user_id = user_id;
        this.landmark_id = landmark_id;
        this.thumbs_up = thumbs_up;
        this.thumbs_down = thumbs_down;
    }

    public Ratings() {

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLandmark_id() {
        return landmark_id;
    }

    public void setLandmark_id(int landmark_id) {
        this.landmark_id = landmark_id;
    }

    public int getThumbs_up() {
        return thumbs_up;
    }

    public void setThumbs_up(int thumbs_up) {
        this.thumbs_up = thumbs_up;
    }

    public int getThumbs_down() {
        return thumbs_down;
    }

    public void setThumbs_down(int thumbs_down) {
        this.thumbs_down = thumbs_down;
    }
}
