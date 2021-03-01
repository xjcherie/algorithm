package leetcode.amber2021;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/02/28
 * https://leetcode.com/problems/valid-anagram/
 **/
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[26], tArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            tArray[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(sArray, tArray);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

//        return Arrays.toString(sArray).compareTo(Arrays.toString(tArray)) == 0 // 效率低
//        return Arrays.equals(sArray, tArray);
        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(isAnagram("anagram", "nagaram"), equalTo(true));
    }
}
