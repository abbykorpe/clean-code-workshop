package com.movierental.rentals;

import java.util.ArrayList;
import java.util.List;

public class Rentals {

    public List<Rental> list = new ArrayList<>();

    public void add(Rental rental) {
        list.add(rental);
    }

    public Double totalAmount() {
        return list.stream().mapToDouble(Rental::amountPayable).reduce(0, Double::sum);
    }

    public Integer totalRenterPoints() {
        return list.stream().mapToInt(Rental::frequentRenterPoints).reduce(0, Integer::sum);
    }

}
