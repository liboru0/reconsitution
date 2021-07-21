package com.liboru.reconsitution.learn.case01;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

    @Getter
    private String name;

    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    /**
     * 生成详单
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentalIterator = rentals.iterator();
        String result = "Rental Record for " + this.getName() + "\n";
        while (rentalIterator.hasNext()) {
            double thisAmount = 0;
            Rental each = rentalIterator.next();

            // determine amounts for each line
            thisAmount = each.getCharge();

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

}
