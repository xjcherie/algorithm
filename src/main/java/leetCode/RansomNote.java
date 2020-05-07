package leetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/03
 * https://leetcode.com/problems/ransom-note/
 **/
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            for (int j = 0; j < magazine.length(); j++) {
                if (set.contains(j)) {
                    continue;
                }
                if (ransomNote.charAt(i) == magazine.charAt(j)) {
                    count++;
                    set.add(j);
                    break;
                }
            }
        }
        return ransomNote.length() == count;
    }

    @Test
    public void test() {
        assertThat(canConstruct("aa", "aab"), equalTo(true));
    }
}
