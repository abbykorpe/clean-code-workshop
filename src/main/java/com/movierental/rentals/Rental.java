package com.movierental.rentals;

import com.movierental.Movie;
import com.movierental.pricing.Pricing;

import java.util.function.Function;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public Double amountPayable() {
        return new Pricing().priceFor.apply(this);
    }

    public Integer frequentRenterPoints() {
        return calculateFrequentRenterPoints.apply(this);
    }

    private Function<Rental, Integer> calculateFrequentRenterPoints = rental -> {
        return isBonusApplicable(rental) ? 2 : 1;
    };

    private Boolean isBonusApplicable(Rental rental) {
        return rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1;
    }

}