package com.stackroute.springbootmongoDB.service;


import com.stackroute.springbootmongoDB.domain.Track;
import com.stackroute.springbootmongoDB.exception.TrackAlreadyExistsException;
import com.stackroute.springbootmongoDB.exception.TrackNotFoundException;
import com.stackroute.springbootmongoDB.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("trackServiceImpl")
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track track1 = trackRepository.save(track);
        if(track1 == null){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return track1;
    }

    @Override
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track update(Track track) {
        return trackRepository.save(track);
    }


    @Override
    public boolean deleteTrack(int trackId) throws TrackNotFoundException {
        getTrackById(trackId);
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public Optional<Track> getTrackById(int id) throws TrackNotFoundException {
        if(!trackRepository.findById(id).isPresent()){
            throw new TrackNotFoundException("track with "+id+"does not exists in the  database");
        }
       return trackRepository.findById(id);
    }

    @Override
    public List<Track> trackByName(String name) throws TrackNotFoundException {

        if(trackRepository.findByTrackName(name).isEmpty()){
            System.out.println("hjbdkkhasfdlkj");
            throw  new TrackNotFoundException("track with " + name +" does not exists");
        }
        return trackRepository.findByTrackName(name);
    }
}
