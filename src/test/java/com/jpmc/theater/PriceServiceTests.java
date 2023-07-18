package com.jpmc.theater;


import com.jpmc.theater.domain.Movie;
import com.jpmc.theater.domain.Showing;
import com.jpmc.theater.service.PriceService;
import com.jpmc.theater.service.UtilDateTimeService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceServiceTests {

    private static PriceService priceService = new PriceService();
    private static UtilDateTimeService utilDateTimeService = new UtilDateTimeService();

    @Test
    void priceService25PercentDiscountTest() {
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(10, 0));
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, showStartTime);
        assertEquals(10, priceService.calculateTicketPrice(showing));
    }
}
