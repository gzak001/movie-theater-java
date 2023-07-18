package com.jpmc.theater.service;

import com.jpmc.theater.domain.Showing;

public class ShowingService {

    private static PriceService priceService = new PriceService();

    public double getMovieFee(Showing showing) {
        return priceService.calculateTicketPrice(showing);
    }
}
