package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/03/24
 * https://leetcode.com/problems/longest-common-prefix/
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String preStr = strs[0];
        for (String str : strs) {
            while (!str.startsWith(preStr)) {
                preStr = preStr.substring(0, preStr.length() - 1);
            }
        }
        return preStr;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        String commonPrefixStr = strs[strs.length - 1];
        for (int i = 0; i < strs.length - 1; i++) {
            int strLength = Math.min(commonPrefixStr.length(), strs[i].length());
            if (strLength == 0) {
                commonPrefixStr = "";
                break;
            }
            for (int j = 0; j < strLength; j++) {
                if (commonPrefixStr.charAt(j) != strs[i].charAt(j)) {
                    commonPrefixStr = commonPrefixStr.substring(0, j);
                    break;
                }
            }
            if (commonPrefixStr.length() > strLength) {
                commonPrefixStr = commonPrefixStr.substring(0, strLength);
            }
        }
        return commonPrefixStr;
    }

    @Test
    public void test() {
        assertThat(longestCommonPrefix(new String[]{"flower", "flow", "flight"}), equalTo("fl"));
        assertThat(longestCommonPrefix(new String[]{"dog", "racecar", "car"}), equalTo(""));
        assertThat(longestCommonPrefix(new String[]{"aaa", "aa", "aaa"}), equalTo("aa"));
        assertThat(longestCommonPrefix(new String[]{"", "", "flight"}), equalTo(""));
        assertThat(longestCommonPrefix(new String[]{}), equalTo(""));
    }
}
