/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Axzyte
 */
package simpledate;

public class SimpleDate {

    int month;
    int day;
    int year;

    public SimpleDate(int month, int day, int year) {
        if (!rangesOK(month, day, year)) {
            throw new IllegalArgumentException("Invalid Date");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    boolean rangesOK(int month, int day, int year) {
        boolean dateOK = true;
        dateOK &= (year > 1841) && (year < 2043); // Year OK?
        dateOK &= (month > 0) && (month < 13); // Month OK?
        dateOK &= (day > 0) && (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8
                || month == 10 || month == 12) && day < 32)
                || ((month == 4 || month == 6 || month == 9 || month == 11) && day < 31)
                || ((month == 2 && isLeap(year)) && day < 30)
                || ((month == 2 && !isLeap(year)) && day < 29));
        return dateOK;
    }

    private boolean isLeap(int year) {

        boolean isLeapYear = true;
        if (year % 4 != 0) {
            isLeapYear = false;
        } else if (year % 100 != 0) {
            isLeapYear = true;
        } else if (year % 400 != 0) {
            isLeapYear = false;
        }
        return isLeapYear;
    }

    public boolean isLeap() {
        return isLeap(year);
    }

    @Override
    public boolean equals(Object obj) {
        boolean areEqual = false;
        if (obj instanceof SimpleDate) {
            SimpleDate simpleDate = (SimpleDate) obj;
            areEqual = simpleDate.getDay() == getDay()
                    && simpleDate.getMonth() == getMonth()
                    && simpleDate.getYear() == getYear();
        }
        return areEqual;
    }
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    public static void main(String[] args) {
        // Test cases for SimpleDate
        try {
            SimpleDate date1 = new SimpleDate(1, 1, 1842);
            System.out.println("Test Case 1: Date is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 1: Date is invalid.");
        }

        try {
            SimpleDate date2 = new SimpleDate(12, 31, 2042);
            System.out.println("Test Case 2: Date is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 2: Date is invalid.");
        }

        try {
            SimpleDate date3 = new SimpleDate(2, 31, 2000);
            System.out.println("Test Case 3: Date is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 3: Date is invalid.");
        }

        try {
            SimpleDate date4 = new SimpleDate(13, 15, 2000);
            System.out.println("Test Case 4: Date is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 4: Date is invalid.");
        }

        try {
            SimpleDate date5 = new SimpleDate(5, 15, 2043);
            System.out.println("Test Case 5: Date is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 5: Date is invalid.");
        }

        // Test cases for NextDate
        try {
            SimpleDate date6 = new SimpleDate(6, 20, 2022);
            SimpleDate nextDate6 = NextDate.nextDate(date6);
            System.out.println("Test Case 6: Next date is " + nextDate6);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 6: Invalid date.");
        }

        try {
            SimpleDate date7 = new SimpleDate(2, 28, 2020);
            SimpleDate nextDate7 = NextDate.nextDate(date7);
            System.out.println("Test Case 7: Next date is " + nextDate7);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 7: Invalid date.");
        }

        try {
            SimpleDate date8 = new SimpleDate(2, 28, 2021);
            SimpleDate nextDate8 = NextDate.nextDate(date8);
            System.out.println("Test Case 8: Next date is " + nextDate8);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 8: Invalid date.");
        }

        try {
            SimpleDate date9 = new SimpleDate(12, 31, 2041);
            SimpleDate nextDate9 = NextDate.nextDate(date9);
            System.out.println("Test Case 9: Next date is " + nextDate9);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 9: Invalid date.");
        }
    }

}
