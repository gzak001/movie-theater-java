package com.jpmc.theater.service;

import java.time.LocalDate;

public class UtilDateTimeService {

    public static LocalDate currentDate = LocalDate.now();

    public LocalDate getCurrentDate() {
        return currentDate;
    }
}
