package com.movierental.pricing;

import com.movierental.rentals.Rental;

import java.util.function.Function;

public class RegularPricing implements PricingStrategy {
    @Override
    public Function<Rental, Double> priceFor() {
        return rental -> {
            int basePrice = 2;
            double finePriceFactor = 1.5;
            int numberOfDaysToBeFined = Math.max(rental.getDaysRented() - 2, 0);

            return basePrice + (numberOfDaysToBeFined * finePriceFactor);
        };
    }
}