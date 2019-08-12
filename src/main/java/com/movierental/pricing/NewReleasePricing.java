package com.movierental.pricing;

import com.movierental.rentals.Rental;

import java.util.function.Function;

public class NewReleasePricing implements PricingStrategy {
    @Override
    public Function<Rental, Double> priceFor() {
        return rental -> {
            double priceFactor = 3;

            return rental.getDaysRented() * priceFactor;
        };
    }
}