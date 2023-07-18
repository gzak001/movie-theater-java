package com.jpmc.theater;


import com.jpmc.theater.domain.Theater;
import com.jpmc.theater.service.TheaterService;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TheaterServiceTests {

   private static TheaterService theaterService = new TheaterService();

    @Test
    void printMovieScheduleTEXTTest() {
        // Run Theater schedule - text
        Theater theater = new Theater();
        String schedule = theaterService.printSchedule(theater,"text");
        assertNotNull(schedule);
    }

    @Test
    void printMovieScheduleJSONTest() {
        // Run Theater schedule - json
        Theater theater = new Theater();
        String schedule = theaterService.printSchedule(theater,"json");
        assertNotNull(schedule);
    }
}
