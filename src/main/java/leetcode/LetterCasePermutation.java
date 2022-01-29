package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/letter-case-permutation/
 **/
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        if (S == null || S.length() == 0) return list;

        String s = S.toLowerCase();
        list.add(s);

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c - 'a' < 0 || c - 'z' > 0) {
                continue;
            }
            int newLength = list.size();
            for (int m = 0; m < newLength; m++) {
                String str = list.get(m);
                list.add(str.substring(0, i) + Character.toUpperCase(c) + (i < length - 1 ? str.substring(i + 1, length) : ""));
            }
        }
        return list;
    }

    @Test
    public void test() {
        letterCasePermutation("a1b2");
    }
}
