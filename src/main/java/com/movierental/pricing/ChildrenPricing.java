package com.movierental.pricing;

import com.movierental.rentals.Rental;

import java.util.function.Function;

public class ChildrenPricing implements PricingStrategy {
    @Override
    public Function<Rental, Double> priceFor() {
        return rental -> {
            double basePrice = 1.5;
            double finePriceFactor = 1.5;
            int numberOfDaysToBeFined = Math.max(rental.getDaysRented() - 3, 0);

            return basePrice + (numberOfDaysToBeFined * finePriceFactor);
        };
    }
}