package com.movierental;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MovieAndRentalFactory {

    private String REGULAR = "Regular-";
    private String NEW_RELEASE = "NewRelease-";
    private String CHILDREN = "Children-";

    public Movie newRegularMovie(String name) {
        return new Movie(name, 0);
    }

    public Movie newNewReleaseMovie(String name) {
        return new Movie(name, 1);
    }

    public Movie newChildrenMovie(String name) {
        return new Movie(name, 2);
    }

    public Movie defaultRegularMovie() {
        return newRegularMovie(REGULAR + "1");
    }

    public Movie defaultNewReleaseMovie() {
        return newNewReleaseMovie(NEW_RELEASE + "1");
    }

    public Movie defaultChildrenMovie() {
        return newChildrenMovie(CHILDREN + "1");
    }

    public Rental newRegularRental(String movieName, int days) {
        return new Rental(newRegularMovie(movieName), days);
    }

    public Rental newNewReleaseRental(String movieName, int days) {
        return new Rental(newNewReleaseMovie(movieName), days);
    }

    public Rental newChildrenRental(String movieName, int days) {
        return new Rental(newChildrenMovie(movieName), days);
    }

    public Rental defaultRegularRental(int days) {
        return new Rental(defaultRegularMovie(), days);
    }

    public Rental defaultNewReleaseRental(int days) {
        return new Rental(defaultNewReleaseMovie(), days);
    }

    public Rental defaultChildrenRental(int days) {
        return new Rental(defaultChildrenMovie(), days);
    }

    public List<Rental> defaultRegularRentals(int numberOfRentals, int daysRented) {
        return IntStream.rangeClosed(1, numberOfRentals).mapToObj(num -> newRegularRental(REGULAR + num, daysRented)).collect(Collectors.toList());
    }

    public List<Rental> defaultNewReleaseRentals(int numberOfRentals, int daysRented) {
        return IntStream.rangeClosed(1, numberOfRentals).mapToObj(num -> newNewReleaseRental(NEW_RELEASE + num, daysRented)).collect(Collectors.toList());
    }

    public List<Rental> defaultChildrenRentals(int numberOfRentals, int daysRented) {
        return IntStream.rangeClosed(1, numberOfRentals).mapToObj(num -> newChildrenRental(CHILDREN + num, daysRented)).collect(Collectors.toList());
    }

}
