package leetcode.string;

import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/01/25
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 **/
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxCount = 1;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char[] tmpArray = new char[s.length()];
            maxCount = Math.max(maxCount, this.recursion(array, tmpArray, i, 0));
        }
        return maxCount;
    }

    private int recursion(char[] array, char[] tmpArray, int index, int count) {
        if (index >= array.length || checkExist(tmpArray, array[index], count)) {
            return count;
        }
        tmpArray[count] = array[index];
        return this.recursion(array, tmpArray, ++index, ++count);
    }

    private boolean checkExist(char[] tmpArray, char c, int count) {
        for (int i = 0; i < count; i++) {
            if (tmpArray[i] == c) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertThat(lengthOfLongestSubstring("abcabcbb"), equalTo(3));
        assertThat(lengthOfLongestSubstring("bbbbb"), equalTo(1));
        assertThat(lengthOfLongestSubstring("pwwkew"), equalTo(3));
    }
}
