package leetcode.amber2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/01/14
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 **/
public class PrefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        long total = 0;
        for (int value : A) {
            total = (total << 1) + value;
            if (total % 5 == 0) {
                result.add(true);
                total = 0;
            } else {
                result.add(false);
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<Boolean> list = new ArrayList<>();
        list.add(false);
        list.add(false);
        list.add(false);
        assertThat(prefixesDivBy5(new int[]{1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0}), equalTo(list));
    }

}
