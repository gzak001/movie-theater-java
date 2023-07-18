package com.jpmc.theater.service;

import com.jpmc.theater.domain.Showing;


public class PriceService {

    private static DiscountService discountService = new DiscountService();

    public double calculateTicketPrice(Showing showing) {
        double ticketPrice = showing.getMovie().getTicketPrice();
        double discountAmount = discountService.getDiscountAmount(showing);
        return (ticketPrice - discountAmount);
    }
}
