package leetcode.heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/12
 * https://leetcode.com/problems/last-stone-weight/
 **/
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        while (list.size() > 1) {
            list.sort((Comparator.reverseOrder()));
            int large = list.get(0);
            int small = list.get(1);
            list.remove(0);
            list.remove(0);
            if (large != small) {
                list.add(large - small);
            }
        }
        return list.size() == 0 ? 0 : list.get(0);
    }

    @Test
    public void test() {
        assertThat(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}), equalTo(1));
    }
}
