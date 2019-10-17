package com.stackroute.springbootmongoDB.repository;


import com.stackroute.springbootmongoDB.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {
    //@Query("SELECT t FROM Track t where t.trackName = :name")
    public List<Track> findByTrackName(String trackName);
}
