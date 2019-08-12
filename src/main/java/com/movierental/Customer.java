package com.movierental;

import com.movierental.rentals.Rental;
import com.movierental.rentals.Rentals;
import com.movierental.statement.HtmlStatementGenerator;
import com.movierental.statement.TextStatementGenerator;

public class Customer {
    private String name;
    private Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public Double totalAmount() {
        return rentals.totalAmount();
    }

    public Integer totalRenterPoints() {
        return rentals.totalRenterPoints();
    }

    public String getName() {
        return name;
    }

    public Rentals rentals() {
        return rentals;
    }

    public String statement() {
        return new TextStatementGenerator().generate(this);
    }

    public String htmlStatement() {
        return new HtmlStatementGenerator().generate(this);
    }

}