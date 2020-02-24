package LeetContest;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * Write a program to count the number of days between two dates.
 *
 * The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
 *
 *
 *
 * Example 1:
 *
 * Input: date1 = "2019-06-29", date2 = "2019-06-30"
 * Output: 1
 * Example 2:
 *
 * Input: date1 = "2020-01-15", date2 = "2019-12-31"
 * Output: 15
 */


class NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = null;
        LocalDate d2 = null;
        try{
            d1 = LocalDate.parse(date1);
            d2 = LocalDate.parse(date2);
        }catch(Exception ex){
            return -1;
        }
        return Math.abs((int) ChronoUnit.DAYS.between(d1, d2));
    }
}