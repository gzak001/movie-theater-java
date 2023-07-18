package com.jpmc.theater.domain;

import java.time.LocalDateTime;


public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;


    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    public void setSequenceOfTheDay(int sequenceOfTheDay) {
        this.sequenceOfTheDay = sequenceOfTheDay;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(LocalDateTime showStartTime) {
        this.showStartTime = showStartTime;
    }

}
