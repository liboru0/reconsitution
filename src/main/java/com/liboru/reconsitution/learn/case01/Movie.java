package com.liboru.reconsitution.learn.case01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;

    @Setter
    private int priceCode;

    public double getCharge(int daysRented){
        double result = 0;
        switch (this.priceCode) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((this.priceCode == Movie.NEW_RELEASE) &&
                daysRented > 1) {
            return 2;
        }
        return 1;
    }

}
