package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/01/27
 * https://leetcode.com/problems/longest-palindromic-substring/
 **/
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String answer = "";
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j >= i; j--) {
                if (!this.isSameChar(array, i, j)) {
                    continue;
                }
                String subStr = s.substring(i, j + 1);
                if (subStr.length() > answer.length()) {
                    answer = subStr;
                }
                if (answer.length() > j - i + 1) {
                    break;
                }
            }
            if (answer.length() > array.length - i) {
                break;
            }
        }
        return answer;
    }

    private boolean isSameChar(char[] array, int leftIndex, int rightIndex) {
        if (rightIndex <= leftIndex) {
            return true;
        }
        if (array[leftIndex] == array[rightIndex]) {
            return this.isSameChar(array, leftIndex + 1, rightIndex - 1);
        }
        return false;
    }

    @Test
    public void test() {
        assertThat(longestPalindrome("babad"), equalTo("bab"));
        assertThat(longestPalindrome("cbbd"), equalTo("bb"));
    }
}
