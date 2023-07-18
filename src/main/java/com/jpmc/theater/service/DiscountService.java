package com.jpmc.theater.service;

import com.jpmc.theater.domain.Movie;
import com.jpmc.theater.domain.Showing;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DiscountService {

    private static UtilDateTimeService utilDateTimeService = new UtilDateTimeService();

    public double getDiscountAmount(Showing showing) {

        Movie movie = showing.getMovie();
        int showSequence= showing.getSequenceOfTheDay();
        LocalDateTime showStartTime = showing.getShowStartTime();

        double maxDiscountAmount = 0;
        double sequenceDiscount = 0;
        double specialDiscount = 0;
        double dateTimeDiscount = 0;

        // 20% discount for special movie
        if (Movie.MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
            specialDiscount = movie.getTicketPrice() * 0.2;
            maxDiscountAmount=getMaxDiscountAmount(maxDiscountAmount,specialDiscount);
            System.out.println("20% discount for special movie:  "+ specialDiscount);
        }

        // 25% discount movies showing starting between 11AM ~ 4pm,
        LocalDateTime lower = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(11, 0));
        LocalDateTime upper = LocalDateTime.of(utilDateTimeService.currentDate, LocalTime.of(16, 0));
        if ((showStartTime.isAfter(lower) || showStartTime.equals(lower)) && (showStartTime.isBefore(upper) || showStartTime.equals(upper))) {
            dateTimeDiscount = movie.getTicketPrice() * 0.25;
            maxDiscountAmount=getMaxDiscountAmount(maxDiscountAmount,dateTimeDiscount);
            System.out.println("25% discount for special movie:  "+ dateTimeDiscount);

        }

        // movies showing on 7th, you'll get 1$ discount
        if(showStartTime.getDayOfMonth() == 7){
            dateTimeDiscount = 1;
            maxDiscountAmount=getMaxDiscountAmount(maxDiscountAmount,dateTimeDiscount);
            System.out.println("7 day discount for special movie:  "+ dateTimeDiscount);
        }

        // $3 discount for 1st show
        if (showSequence == 1) {
            sequenceDiscount = 3;
            maxDiscountAmount=getMaxDiscountAmount(maxDiscountAmount,sequenceDiscount);
            System.out.println("$3 discount for 1st show:  "+ sequenceDiscount);
        }
        // $2 discount for 2nd show
        if (showSequence == 2) {
            sequenceDiscount = 2;
            maxDiscountAmount=getMaxDiscountAmount(maxDiscountAmount,sequenceDiscount);
            System.out.println("$2 discount for 2nd show:  "+ sequenceDiscount);
        }
        System.out.println("maxDiscount:  "+ maxDiscountAmount);
        // return maxDiscountAmount
        return maxDiscountAmount;
    }

    private double getMaxDiscountAmount(double maxDiscountAmount,double discountAmount) {
        if (discountAmount > maxDiscountAmount) {
            maxDiscountAmount = discountAmount;
        }
        return maxDiscountAmount;
    }

}
