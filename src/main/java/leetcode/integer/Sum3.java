package leetcode.integer;

import java.util.*;

/**
 * Created by Cherie on 2022/02/11
 * https://leetcode.com/problems/3sum/
 **/
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int leftIndex = i + 1, rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int total = first + nums[leftIndex] + nums[rightIndex];
                if (total == 0) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(first);
                    subList.add(nums[leftIndex]);
                    subList.add(nums[rightIndex]);
                    set.add(subList);
                    leftIndex++;
                    rightIndex--;
                } else if (total < 0) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }
        return new ArrayList<>(set);
    }

}
