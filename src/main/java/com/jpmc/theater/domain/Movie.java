package com.jpmc.theater.domain;

import java.time.Duration;
import java.util.Objects;

public class Movie {
    public static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public static int getMovieCodeSpecial() {
        return MOVIE_CODE_SPECIAL;
    }

    public static void setMovieCodeSpecial(int movieCodeSpecial) {
        MOVIE_CODE_SPECIAL = movieCodeSpecial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(int specialCode) {
        this.specialCode = specialCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(ticketPrice, movie.getTicketPrice())
                && Objects.equals(title, movie.getTitle())
                && Objects.equals(description, movie.getDescription())
                && Objects.equals(runningTime, movie.getRunningTime())
                && Objects.equals(specialCode, movie.getSpecialCode())
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}