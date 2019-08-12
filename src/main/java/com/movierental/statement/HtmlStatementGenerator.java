package com.movierental.statement;

import com.movierental.Customer;
import com.movierental.rentals.Rental;
import com.movierental.rentals.Rentals;

import java.util.function.Function;

public class HtmlStatementGenerator implements StatementGenerator {

    @Override
    public String generate(Customer customer) {
        return headingText.apply(customer.getName()) +
                generateTextForAllRentals.apply(customer.rentals()) +
                totalAmountText.apply(customer.totalAmount()) +
                totalRenterPointsText.apply(customer.totalRenterPoints());
    }

    private Function<Double, String> totalAmountText = totalAmount -> {
        return "Amount owed is <B>" + totalAmount + "</B><BR>";
    };

    private Function<Integer, String> totalRenterPointsText = totalRenterPoints -> {
        return "You earned <B>" + totalRenterPoints + "</B> frequent renter points";
    };

    private Function<String, String> headingText = customerName -> {
        return "<H1>Rental Record for <B>" + customerName + "</B></H1><BR>";
    };

    private Function<Rental, String> generateTextForEachRental = rental -> {
        return rental.getMovie().getTitle() + " " + rental.amountPayable() + "<BR>";
    };

    private Function<Rentals, String> generateTextForAllRentals = rentals -> {
        return rentals.list.stream().map(r -> generateTextForEachRental.apply(r)).reduce("", String::concat);
    };

}
