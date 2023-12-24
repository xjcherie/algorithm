package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Cherie on 2023/12/17
 * <a href="https://leetcode.com/problems/summary-ranges/">228. Summary Ranges</a>
 **/
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return Collections.emptyList();
        }

        List<String> list = new ArrayList<>();
        if (length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }

        int start = nums[0];
        int end = start;
        for (int i = 1; i < length - 1; i++) {
            int num = nums[i];
            if (num == end + 1) {
                end = num;
            } else {
                if (start == end) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + end);
                }
                start = num;
                end = num;
            }
        }
        int lastNum = nums[length - 1];
        if (lastNum == end + 1) {
            list.add(start + "->" + lastNum);
        } else {
            if (start == end) {
                list.add(String.valueOf(start));
            } else {
                list.add(start + "->" + end);
            }
            list.add(String.valueOf(lastNum));
        }
        return list;
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("0->2");
        list.add("4->5");
        list.add("7");
        Assert.assertEquals(list, summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }
}
