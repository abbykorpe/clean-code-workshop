package com.movierental.pricing;

import com.movierental.rentals.Rental;

import java.util.function.Function;

public interface PricingStrategy {
    Function<Rental, Double> priceFor();
}