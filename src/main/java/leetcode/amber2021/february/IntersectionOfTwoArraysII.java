package leetcode.amber2021.february;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/02/03
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 **/
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length, length2 = nums2.length;
        int[] result = new int[Math.min(length1, length2)];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int i1 = nums1[index1], i2 = nums2[index2];
            if (i1 == i2) {
                result[index] = i1;
                index++;
                index1++;
                index2++;
            } else if (i1 < i2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int value : nums1) {
            list1.add(value);
        }

        List<Integer> list = new ArrayList<>();
        for (int i2 : nums2) {
            Iterator<Integer> it = list1.iterator();
            while (it.hasNext()) {
                if (it.next() == i2) {
                    list.add(i2);
                    it.remove();
                    break;
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void test() {
        assertThat(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}), equalTo(new int[]{2, 2}));
    }
}
