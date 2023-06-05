/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Axzyte
 */
package simpledate;

import simpledate.SimpleDate;

public class NextDate {

    public SimpleDate NextDate() {
        return new SimpleDate(1, 1, 2000);

    }

    public static SimpleDate nextDate(SimpleDate date) {

        int tomorrowDay, tomorrowMonth, tomorrowYear;
        tomorrowMonth = date.month;
        tomorrowDay = date.day;
        tomorrowYear = date.year;
        switch (date.month) {
            // 31 day months (except Dec.)
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (date.day < 31) {
                    tomorrowDay = date.day + 1;
                } else {
                    tomorrowDay = 1;
                    tomorrowMonth = date.month + 1;
                }
                break;
            // 30 day months
            case 4:
            case 6:
            case 9:
            case 11:
                if (date.day < 30) {
                    tomorrowDay = date.day + 1;
                } else {
                    tomorrowDay = 1;
                    tomorrowMonth = date.month + 1;
                }
                break;
            // December
            case 12:
                if (date.day < 31) {
                    tomorrowDay = date.day + 1;
                } else {
                    tomorrowDay = 1;
                    tomorrowMonth = 1;
                    if (date.year == 2042) {
                        System.out.println("Date beyond 2042 ");
                    } else {
                        tomorrowYear = date.year + 1;
                    }
                }
                break;
            // February
            case 2:
                if (date.day < 28) {
                    tomorrowDay = date.day + 1;
                } else {
                    if (date.day == 28) {
                        if (date.isLeap()) {
                            tomorrowDay = 29;
                        } else {
                            tomorrowDay = 1;
                            tomorrowMonth = 3;
                        }
                    } else if (date.day == 29) {
                        tomorrowDay = 1;
                        tomorrowMonth = 3;
                    }
                }
                break;
        }
        return new SimpleDate(tomorrowMonth, tomorrowDay,
                tomorrowYear);

    }
}
