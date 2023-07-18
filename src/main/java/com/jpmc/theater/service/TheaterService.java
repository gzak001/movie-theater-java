package com.jpmc.theater.service;

import com.google.gson.Gson;
import com.jpmc.theater.domain.Customer;
import com.jpmc.theater.domain.Reservation;
import com.jpmc.theater.domain.Showing;
import com.jpmc.theater.domain.Theater;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TheaterService {


    private static ShowingService showingService = new ShowingService();
    private static UtilDateTimeService utilDateTimeService = new UtilDateTimeService();
    private static ReservationService reservationService = new ReservationService();
    private static TheaterService theaterService = new TheaterService();

    private static final String PRINT_SCHEDULE_TEXT = "TEXT";
    private static final String PRINT_SCHEDULE_JSON = "JSON";


    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        return reservationService.reserve(customer, sequence, howManyTickets);
    }

    public String printSchedule(Theater theater, String type) {
        type = type.toUpperCase();
        String result = null;
        switch (type) {
            case PRINT_SCHEDULE_TEXT:
                result= printScheduleText(theater);
                break;
            case PRINT_SCHEDULE_JSON:
                result=printScheduleJson(theater);
                break;
            default:
                System.out.println("ERROR - Type must have type text or json");
        }
        return result;

    }

    private String printScheduleJson(Theater theater) {

        List<Showing> schedule = theater.getSchedule();

        System.out.println("===================================================");
        System.out.println("Theater Schedule JSON - Current Date: " + utilDateTimeService.getCurrentDate());
        Gson gson = new Gson();
        String json = gson.toJson(schedule);
        System.out.println(json);
        System.out.println("===================================================");
        return json;
    }

    private String printScheduleText(Theater theater) {

        List<Showing> schedule = theater.getSchedule();

        System.out.println("===================================================");
        System.out.println("Theater Schedule TEXT - Current Date: " + utilDateTimeService.getCurrentDate());
        schedule.forEach(s ->
                System.out.println(s.getSequenceOfTheDay() + ": " + s.getShowStartTime() + " " + s.getMovie().getTitle() + " " + humanReadableFormat(s.getMovie().getRunningTime()) + " $" + showingService.getMovieFee(s))
        );
        System.out.println("===================================================");
        return schedule.toString();
    }

    private String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value == 1) {
            return "";
        } else {
            return "s";
        }
    }

    public static void main(String[] args) {
        Theater theater = new Theater();
        theaterService.printSchedule(theater, "text");
        theaterService.printSchedule(theater, "json");
    }
}
