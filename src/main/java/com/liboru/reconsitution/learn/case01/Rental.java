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

}
