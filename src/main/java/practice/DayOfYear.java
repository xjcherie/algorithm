package practice;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/05/19
 **/
public class DayOfYear {

    private static final int[] DAYS_OF_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final int[] FIRST_DAY_OF_MONTH = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    /**
     * Days after the 16th century
     */
    public int dayOfYear(int year, int month, int day) {
        if (month <= 0 || month > 12 || day <= 0 || (month != 2 && day > DAYS_OF_MONTH[month - 1])) {
            return -1;
        }
        boolean isLeapYear = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
        if (month == 2 && ((isLeapYear && day > 29) || (!isLeapYear && day > 28))) {
            return -1;
        }
        return FIRST_DAY_OF_MONTH[month - 1] + day + ((month > 2 && isLeapYear) ? 1 : 0);
    }

    @Test
    public void test() {
        assertThat(dayOfYear(2016, 1, 3), equalTo(3));
    }

    public static void main(String[] args) {
        int[] daysOfMonth = new int[12];
        int[] firstDayOfMonth = new int[12];
        int sum = 0;
        for (int i = 1; i <= 12; i++) {
            int days = 30;
            if (i == 2) {
                days = 28;
            } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                days = 31;
            }
            daysOfMonth[i - 1] = days;
            firstDayOfMonth[i - 1] = sum;
            sum += days;
        }
        System.out.println(Arrays.toString(daysOfMonth));
        System.out.println(Arrays.toString(firstDayOfMonth));
    }
}
