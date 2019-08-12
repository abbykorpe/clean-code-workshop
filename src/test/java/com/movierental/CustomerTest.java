package com.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    MovieAndRentalFactory factory = new MovieAndRentalFactory();

    @Test
    public void itShouldGenerateStatementForNoRental() {
        //given
        Customer newCustomer = new Customer("James Bond");
        String expected = "Rental Record for James Bond\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        //when
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForOneRegularRentalForOneDay() {
        //given
        Customer newCustomer = new Customer("James Bond");
        String expected = "Rental Record for James Bond\n" +
                "\tRegular-1\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        //when
        newCustomer.addRental(factory.defaultRegularRental(1));
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForOneRegularRentalForMoreThanTwoDays() {
        //given
        Customer newCustomer = new Customer("James Bond");
        String expected = "Rental Record for James Bond\n" +
                "\tRegular-1\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points";

        //when
        newCustomer.addRental(factory.defaultRegularRental(4));
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForOneNewReleaseRentalForOneDay() {
        //given
        Customer newCustomer = new Customer("Harry Potter");
        String expected = "Rental Record for Harry Potter\n" +
                "\tNewRelease-1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        //when
        newCustomer.addRental(factory.defaultNewReleaseRental(1));
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForOneNewReleaseRentalForMoreThanTwoDays() {
        //given
        Customer newCustomer = new Customer("Harry Potter");
        String expected = "Rental Record for Harry Potter\n" +
                "\tNewRelease-1\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 2 frequent renter points";

        //when
        newCustomer.addRental(factory.defaultNewReleaseRental(4));
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForOneChildrenRentalForOneDay() {
        //given
        Customer newCustomer = new Customer("Peter Pan");
        String expected = "Rental Record for Peter Pan\n" +
                "\tChildren-1\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";

        //when
        newCustomer.addRental(factory.defaultChildrenRental(1));
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForOneChildrenRentalForMoreThanThreeDays() {
        //given
        Customer newCustomer = new Customer("Peter Pan");
        String expected = "Rental Record for Peter Pan\n" +
                "\tChildren-1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        //when
        newCustomer.addRental(factory.defaultChildrenRental(4));
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForOneOfEachRentalForOneDay() {
        //given
        Customer newCustomer = new Customer("Peter Pan");
        String expected = "Rental Record for Peter Pan\n" +
                "\tRegular-1\t2.0\n" +
                "\tNewRelease-1\t3.0\n" +
                "\tChildren-1\t1.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 3 frequent renter points";

        //when
        newCustomer.addRental(factory.defaultRegularRental(1));
        newCustomer.addRental(factory.defaultNewReleaseRental(1));
        newCustomer.addRental(factory.defaultChildrenRental(1));
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForOneOfEachRentalForMoreThanThreeDays() {
        //given
        Customer newCustomer = new Customer("Peter Pan");
        String expected = "Rental Record for Peter Pan\n" +
                "\tRegular-1\t5.0\n" +
                "\tNewRelease-1\t12.0\n" +
                "\tChildren-1\t3.0\n" +
                "Amount owed is 20.0\n" +
                "You earned 4 frequent renter points";

        //when
        newCustomer.addRental(factory.defaultRegularRental(4));
        newCustomer.addRental(factory.defaultNewReleaseRental(4));
        newCustomer.addRental(factory.defaultChildrenRental(4));
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForTwoOfEachRentalForOneDay() {
        //given
        Customer newCustomer = new Customer("Peter Pan");
        String expected = "Rental Record for Peter Pan\n" +
                "\tRegular-1\t2.0\n" +
                "\tRegular-2\t2.0\n" +
                "\tNewRelease-1\t3.0\n" +
                "\tNewRelease-2\t3.0\n" +
                "\tChildren-1\t1.5\n" +
                "\tChildren-2\t1.5\n" +
                "Amount owed is 13.0\n" +
                "You earned 6 frequent renter points";

        //when
        factory.defaultRegularRentals(2, 1).forEach(newCustomer::addRental);
        factory.defaultNewReleaseRentals(2, 1).forEach(newCustomer::addRental);
        factory.defaultChildrenRentals(2, 1).forEach(newCustomer::addRental);
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itShouldGenerateStatementForTwoOfEachRentalForMoreThanThreeDays() {
        //given
        Customer newCustomer = new Customer("Peter Pan");
        String expected = "Rental Record for Peter Pan\n" +
                "\tRegular-1\t5.0\n" +
                "\tRegular-2\t5.0\n" +
                "\tNewRelease-1\t12.0\n" +
                "\tNewRelease-2\t12.0\n" +
                "\tChildren-1\t3.0\n" +
                "\tChildren-2\t3.0\n" +
                "Amount owed is 40.0\n" +
                "You earned 8 frequent renter points";

        //when
        factory.defaultRegularRentals(2, 4).forEach(newCustomer::addRental);
        factory.defaultNewReleaseRentals(2, 4).forEach(newCustomer::addRental);
        factory.defaultChildrenRentals(2, 4).forEach(newCustomer::addRental);
        String actual = newCustomer.statement();

        //then
        Assert.assertEquals(expected, actual);
    }

}