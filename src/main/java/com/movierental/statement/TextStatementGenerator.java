package com.movierental.statement;

import com.movierental.Customer;
import com.movierental.rentals.Rental;
import com.movierental.rentals.Rentals;

import java.util.function.Function;

public class TextStatementGenerator implements StatementGenerator {
    @Override
    public String generate(Customer customer) {
        return headingText.apply(customer.getName()) +
                generateTextForAllRentals.apply(customer.rentals()) +
                totalAmountText.apply(customer.totalAmount()) +
                totalRenterPointsText.apply(customer.totalRenterPoints());
    }

    private Function<Double, String> totalAmountText = totalAmount -> {
        return "Amount owed is " + totalAmount + "\n";
    };

    private Function<Integer, String> totalRenterPointsText = totalRenterPoints -> {
        return "You earned " + totalRenterPoints + " frequent renter points";
    };

    private Function<String, String> headingText = customerName -> {
        return "Rental Record for " + customerName + "\n";
    };

    private Function<Rental, String> generateTextForEachRental = rental -> {
        return  "\t" + rental.getMovie().getTitle() + "\t" + rental.amountPayable() + "\n";
    };

    private Function<Rentals, String> generateTextForAllRentals = rentals -> {
        return rentals.list.stream().map(r -> generateTextForEachRental.apply(r)).reduce("", String::concat);
    };

}