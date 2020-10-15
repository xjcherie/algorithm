package leetcode.math;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/03/17
 * https://leetcode.com/problems/palindrome-number/
 **/
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseDigit = 0;
        while (x > reverseDigit) {
            reverseDigit = reverseDigit * 10 + x % 10;
            x /= 10;
        }
        return x == reverseDigit || x == reverseDigit / 10;
    }

    public boolean compareHalfNum(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int times = (int) Math.log10(x);
        int xHalfCount = times / 2;
        int rightReverseDigit = 0;
        for (int i = 0; i <= xHalfCount; i++) {
            rightReverseDigit += (x / (int) Math.pow(10, i) % 10) * ((int) Math.pow(10, xHalfCount - i));
        }
        int leftHalfDigit = x / (int) (Math.pow(10, (times + 1) / 2));
        return leftHalfDigit == rightReverseDigit;
    }

    public boolean compareReverseDigit(int x) {
        if (x < 0) {
            return false;
        }
        int times = (int) Math.log10(x);
        int reverseDigit = 0;
        for (int i = 0; i <= times; i++) {
            reverseDigit += (x / (int) Math.pow(10, i) % 10) * ((int) Math.pow(10, times - i));
            if (reverseDigit < 0) {
                return false;
            }
        }
        return x == reverseDigit;
    }

    public boolean compareSingleDigit(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }
        int times = (int) Math.log10(x);
        int leftNum = x / (int) (Math.pow(10, times));
        int rightNum = x % (int) (Math.pow(10, times)) % 10;
        if (leftNum != rightNum) {
            return false;
        }

        int middle = x % (int) (Math.pow(10, times)) / 10;
        if (times > 1 && middle > 0) {
            int leftZeroCount = times - (int) Math.log10(middle) - 2;
            if (leftZeroCount > 0) {
                int rightZeroNum = middle % (int) (Math.pow(10, leftZeroCount));
                if (rightZeroNum > 0) {
                    return false;
                }
                middle = middle / (int) (Math.pow(10, leftZeroCount));
            }
            return compareSingleDigit(middle);
        }
        return true;
    }

    public boolean compareByStr(int x) {
        String xStr = String.valueOf(x);
        for (int i = 0; i < xStr.length() / 2; i++) {
            if (xStr.charAt(i) != xStr.charAt(xStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(isPalindrome(2147483647), equalTo(false));
        assertThat(isPalindrome(120021), equalTo(true));
        assertThat(isPalindrome(1205021), equalTo(true));
        assertThat(isPalindrome(12005021), equalTo(false));
        assertThat(isPalindrome(1200500021), equalTo(false));
        assertThat(isPalindrome(100021), equalTo(false));
        assertThat(isPalindrome(12021), equalTo(true));
        assertThat(isPalindrome(12921), equalTo(true));
        assertThat(isPalindrome(1), equalTo(true));
        assertThat(isPalindrome(10), equalTo(false));
        assertThat(isPalindrome(11), equalTo(true));
        assertThat(isPalindrome(0), equalTo(true));
        assertThat(isPalindrome(-1), equalTo(false));
        assertThat(isPalindrome(-10), equalTo(false));
        assertThat(isPalindrome(-11), equalTo(false));
    }
}
