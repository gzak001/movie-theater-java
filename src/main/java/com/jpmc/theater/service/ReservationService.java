package com.jpmc.theater.service;

import com.jpmc.theater.dao.ShowingDAO;
import com.jpmc.theater.domain.Customer;
import com.jpmc.theater.domain.Reservation;
import com.jpmc.theater.domain.Showing;

import java.util.List;


public class ReservationService {

    private static PriceService priceService = new PriceService();
    private static ShowingDAO showingDAO = new ShowingDAO();


    public double totalFee(Reservation reservation) {
        double ticketPrice = priceService.calculateTicketPrice(reservation.getShowing());
        int audienceCount = reservation.getAudienceCount();
        return (ticketPrice * audienceCount);
    }

    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        List<Showing> schedule = showingDAO.getShowings();
        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return new Reservation(customer, showing, howManyTickets);
    }
}