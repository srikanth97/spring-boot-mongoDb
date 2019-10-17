package com.stackroute.springbootmongoDB.exception;

public class TrackNotFoundException extends Exception {

    private String message;

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public TrackNotFoundException() {
    }
}
