package leetCode;

import java.util.Arrays;

/**
 * Created by Cherie on 2020/05/18
 * https://leetcode.com/problems/permutation-in-string/
 * todo
 **/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        char[] s1Array = this.sortString(s1);

        for (int i = 0; i <= s2.length() - s1Length; i++) {
            char[] s2Array = this.sortString(s2.substring(i, i + s1Length));
            if (Arrays.equals(s1Array, s2Array)) {
                return true;
            }
        }
        return false;
    }

    private char[] sortString(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return array;
    }
}
