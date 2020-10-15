package leetcode;

/**
 * Created by Cherie on 2020/05/12
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 **/
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num ^= i;
        }
        return num;
    }
}
