package com.jpmc.theater.domain;


import com.jpmc.theater.dao.ShowingDAO;

import java.util.List;

public class Theater {

    private static ShowingDAO showingDAO = new ShowingDAO();

    private List<Showing> schedule;

    public Theater() {

        schedule = showingDAO.getShowings();
    }

    public List<Showing> getSchedule() {

        return schedule;
    }

    public void setSchedule(List<Showing> schedule) {

        this.schedule = schedule;
    }
}
