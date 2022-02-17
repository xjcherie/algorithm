package leetcode.integer;

import java.util.*;

/**
 * Created by Cherie on 2022/02/17
 * https://leetcode.com/problems/4sum/
 **/
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i];
                int second = nums[j];
                int leftIndex = j + 1, rightIndex = nums.length - 1;
                while (leftIndex < rightIndex) {
                    int total = first + second + nums[leftIndex] + nums[rightIndex];
                    if (total == target) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(first);
                        subList.add(second);
                        subList.add(nums[leftIndex]);
                        subList.add(nums[rightIndex]);
                        set.add(subList);
                        leftIndex++;
                        rightIndex--;
                    } else if (total < target) {
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
