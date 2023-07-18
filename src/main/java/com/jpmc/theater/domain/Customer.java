package com.jpmc.theater.domain;

import java.util.Objects;

public class Customer {

    private String id;
    private String name;


    /**
     * @param name customer name
     * @param id   customer id
     */
    public Customer(String name, String id) {
        this.id = id; // NOTE - id is not used anywhere at the moment
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.getName())
                && Objects.equals(id, customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return ("name: " + name +" Id: " + id);
    }
}