package com.jpmc.theater.dao;

import com.jpmc.theater.domain.Movie;
import com.jpmc.theater.domain.Showing;
import com.jpmc.theater.service.UtilDateTimeService;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ShowingDAO {

    private static final UtilDateTimeService utilDateTimeService = new UtilDateTimeService();

    public List<Showing> getShowings(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
        List<Showing> schedule = List.of(
                new Showing(turningRed, 1, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(9, 0))),
                new Showing(spiderMan, 2, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(11, 0))),
                new Showing(theBatMan, 3, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(12, 50))),
                new Showing(turningRed, 4, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(14, 30))),
                new Showing(spiderMan, 5, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(16, 10))),
                new Showing(theBatMan, 6, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(17, 50))),
                new Showing(turningRed, 7, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(19, 30))),
                new Showing(spiderMan, 8, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(21, 10))),
                new Showing(theBatMan, 9, LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(23, 0)))
        );
        return schedule;
    };

}
