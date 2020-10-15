package leetcode.binary_search;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/01
 * https://leetcode.com/problems/first-bad-version/
 * todo
 **/
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int first = 1, last = n, middle;
        boolean isBad;
        while (first < last) {
            middle = (int) (((long) first + (long) last) / 2);
            isBad = isBadVersion(middle);
            if (first == middle) {
                if (isBad) {
                    return first;
                } else {
                    return last;
                }
            }
            if (isBad) {
                last = middle;
            } else {
                first = middle;
            }
        }
        return first;
    }

    private boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    @Test
    public void test() {
        assertThat(firstBadVersion(2126753390), equalTo(1702766719));
    }

}
