package com.stackroute.springbootmongoDB.initialization;


import com.stackroute.springbootmongoDB.domain.Track;
import com.stackroute.springbootmongoDB.exception.TrackAlreadyExistsException;
import com.stackroute.springbootmongoDB.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@Component
@PropertySource("application.properties")
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Qualifier("trackServiceImpl")
    @Autowired
    private TrackService trackService;
    @Value("${track2.trackId}")
    private int trackId;

    @Value("${track2.trackName}")
    private String trackName;

    @Value("${track2.comments}")
    private String comments;

    @Override
    public void run(String... args) throws Exception {
        try {
            trackService.saveTrack(new Track(trackId,trackName,comments));
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
