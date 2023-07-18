package com.jpmc.theater;

import com.jpmc.theater.service.UtilDateTimeService;
import org.junit.jupiter.api.Test;

public class UtilDateTimeServiceTests {

    UtilDateTimeService utilDateTimeService = new UtilDateTimeService();

    @Test
    void makeSureCurrentTime() {
        System.out.println("current time is - " + utilDateTimeService.getCurrentDate());
    }
}
