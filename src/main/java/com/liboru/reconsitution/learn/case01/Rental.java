package com.liboru.reconsitution.learn.case01;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 租赁，表示某个顾客租了一部影片
 */
@AllArgsConstructor
@Getter
public class Rental {

    private Movie movie;
    private int daysRented;

    public double getCharge(){
        double result = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (this.getDaysRented() > 2) {
                    result += (this.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += this.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (this.getDaysRented() > 3) {
                    result += (this.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                this.getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }

}
