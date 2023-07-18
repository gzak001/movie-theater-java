package com.jpmc.theater;


import com.jpmc.theater.domain.*;
import com.jpmc.theater.service.ReservationService;
import com.jpmc.theater.service.UtilDateTimeService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationServiceTests {

    private static ReservationService reservationService = new ReservationService();
    private static UtilDateTimeService utilDateTimeService = new UtilDateTimeService();

    @Test
    void totalFeeDiscountFirstShowTest() {
        // $3 discount for 1st show
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(10, 0));
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                showStartTime
        );
        double totalFee = reservationService.totalFee(new Reservation(customer, showing, 3));
        System.out.println("totalFee:  " + totalFee);
        assertTrue(totalFee == 28.5);
    }

    @Test
    void totalFeeDiscountSecondShowTest() {
        // $2 discount for 2nd show
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(10, 0));
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                2,
                showStartTime
        );
        double totalFee = reservationService.totalFee(new Reservation(customer, showing, 3));
        System.out.println("totalFee:  " + totalFee);
        assertTrue(totalFee == 31.5);
    }

    @Test
    void totalFeeDiscount20percentTest() {
        // 20% discount for special movie
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(10, 0));
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                2,
                showStartTime
        );
        double totalFee = reservationService.totalFee(new Reservation(customer, showing, 3));
        System.out.println("totalFee:  " + totalFee);
        assertTrue(totalFee == 30.0);
    }

    @Test
    void totalFeeDiscount25percentTest() {
        // 25% discount movies showing starting between 11AM ~ 4pm,
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(11, 0));
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                2,
                showStartTime
        );
        double totalFee = reservationService.totalFee(new Reservation(customer, showing, 3));
        System.out.println("totalFee:  " + totalFee);
        assertTrue(totalFee == 28.125);
    }

    @Test
    void totalFeeDiscount7DayTest() {
        // movies showing on 7th, you'll get 1$ discount
        LocalDateTime showStartTime = LocalDateTime.of(utilDateTimeService.currentDate.withDayOfMonth(7), LocalTime.of(18, 0));
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                3,
                showStartTime
        );
        double totalFee = reservationService.totalFee(new Reservation(customer, showing, 3));
        System.out.println("totalFee:  " + totalFee);
        assertTrue(totalFee == 34.5);
    }

    @Test
    void totalFeeUsingReservationReserveTest() {
        // Testing reservationService.reserve -gets movie from theater schedule list
        Customer customer = new Customer("John Doe", "id-12345");
        Reservation reservation = reservationService.reserve(customer, 2, 4);
        double totalFee = reservationService.totalFee(reservation);
        System.out.println("totalFee:  " + totalFee);
        assertEquals(totalFee, 37.5);
    }
}
