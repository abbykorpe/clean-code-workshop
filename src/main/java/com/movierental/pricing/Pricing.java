package com.movierental.pricing;

import com.movierental.Movie;
import com.movierental.rentals.Rental;

import java.util.function.Function;

public class Pricing {

    public Function<Rental, Double> priceFor = rental -> {
        int priceCode = rental.getMovie().getPriceCode();
        return strategyFor(priceCode).priceFor().apply(rental);
    };

    private PricingStrategy strategyFor(int priceCode) {
        if (priceCode == Movie.REGULAR) {
            return new RegularPricing();
        } else if (priceCode == Movie.NEW_RELEASE) {
            return new NewReleasePricing();
        } else if (priceCode == Movie.CHILDRENS) {
            return new ChildrenPricing();
        } else return new RegularPricing();
    }

}