package com.jpmc.theater;

import com.jpmc.theater.domain.Customer;
import com.jpmc.theater.domain.Movie;
import com.jpmc.theater.domain.Showing;
import com.jpmc.theater.service.ShowingService;
import com.jpmc.theater.service.UtilDateTimeService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShowingServiceTests {

    private static ShowingService showingService = new ShowingService();
    private static UtilDateTimeService utilDateTimeService = new UtilDateTimeService();

    @Test
    void getMovieFeeTest() {
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(10, 0));
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                2,
                showStartTime
        );
        double movieFee = showingService.getMovieFee(showing);
        System.out.println("movieFee:  " + movieFee);
        assertTrue(movieFee == 10.5);
    }
}
