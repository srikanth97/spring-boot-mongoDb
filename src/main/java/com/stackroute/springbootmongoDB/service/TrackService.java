package com.stackroute.springbootmongoDB.service;


import com.stackroute.springbootmongoDB.domain.Track;
import com.stackroute.springbootmongoDB.exception.TrackAlreadyExistsException;
import com.stackroute.springbootmongoDB.exception.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getTracks();

    public Track update(Track track);

    public boolean deleteTrack(int trackId) throws TrackNotFoundException;

    public Optional<Track> getTrackById(int id) throws TrackNotFoundException;

    public List<Track> trackByName(String name) throws TrackNotFoundException;
}
