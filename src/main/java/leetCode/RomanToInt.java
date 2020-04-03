package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/03/21
 * https://leetcode.com/problems/roman-to-integer/
 **/
public class RomanToInt {

    public int romanToInt(String s) {
        int result = 0;

        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = getNum(s.charAt(i));
        }
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1 && a[i] < a[i + 1]) {
                result -= a[i];
                i++;
            }
            result += a[i];
        }
        return result;
    }

    public int romanToInt2(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int num = getNum(s.charAt(i));
            int nextNum = getNum(s.charAt(i + 1));
            if (num < nextNum) {
                result -= num;
            } else {
                result += num;
            }
        }
        result += getNum(s.charAt(s.length() - 1));
        return result;
    }

    private int getNum(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }

    @Test
    public void test() {
        assertThat(romanToInt("III"), equalTo(3));
        assertThat(romanToInt("IV"), equalTo(4));
        assertThat(romanToInt("LVIII"), equalTo(58));
        assertThat(romanToInt("MCMXCIV"), equalTo(1994));
    }
}
