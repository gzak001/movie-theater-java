package com.jpmc.theater;


import com.jpmc.theater.domain.Movie;
import com.jpmc.theater.domain.Showing;
import com.jpmc.theater.service.DiscountService;
import com.jpmc.theater.service.UtilDateTimeService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscountServiceTests {

    private static DiscountService discountService = new DiscountService();
    private static UtilDateTimeService utilDateTimeService = new UtilDateTimeService();

    @Test
    void totalFeeDiscountFirstShowTest() {
        // $3 discount for 1st show
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(10, 0));
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                showStartTime
        );
        double discountAmount = discountService.getDiscountAmount(showing);
        System.out.println("discountAmount:  " + discountAmount);
        assertTrue(discountAmount == 3.0);
    }

    @Test
    void totalFeeDiscountSecondShowTest() {
        // $2 discount for 2nd show
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(10, 0));
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                2,
                showStartTime
        );
        double discountAmount = discountService.getDiscountAmount(showing);
        System.out.println("discountAmount:  " + discountAmount);
        assertTrue(discountAmount == 2.0);
    }

    @Test
    void totalFeeDiscount20percentTest() {
        // 20% discount for special movie
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(10, 0));
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                2,
                showStartTime
        );
        double discountAmount = discountService.getDiscountAmount(showing);
        System.out.println("discountAmount:  " + discountAmount);
        assertTrue(discountAmount == 2.5);
    }

    @Test
    void totalFeeDiscount25percentTest() {
        // 25% discount movies showing starting between 11AM ~ 4pm,
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(11, 0));
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                2,
                showStartTime
        );
        double discountAmount = discountService.getDiscountAmount(showing);
        System.out.println("discountAmount:  " + discountAmount);
        assertTrue(discountAmount == 3.125);
    }

    @Test
    void totalFeeDiscount7DayTest() {
        // movies showing on 7th, you'll get 1$ discount
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate.withDayOfMonth(7), LocalTime.of(18, 0));
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                3,
                showStartTime
        );
        double discountAmount = discountService.getDiscountAmount(showing);
        System.out.println("discountAmount:  " + discountAmount);
        assertTrue(discountAmount == 1.0);
    }
}
