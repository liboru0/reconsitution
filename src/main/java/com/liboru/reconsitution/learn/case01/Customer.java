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
            Rental each = rentalIterator.next();
            frequentRenterPoints += each.getFrequentRenterPoints();
            // show figures for this rental
            // 将 thisAmount 临时变量去除，但调用多次 each.getCharge() 会付出
            // 性能上的代价，但是这可以在 Rental 类中优化
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

}
