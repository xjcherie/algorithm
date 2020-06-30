package leetCode;

/**
 * Created by Cherie on 2020/05/27
 * https://leetcode.com/problems/container-with-most-water/
 **/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0, leftIndex = 0, rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                max = Math.max(max, (rightIndex - leftIndex) * height[leftIndex]);
                leftIndex++;
            } else {
                max = Math.max(max, (rightIndex - leftIndex) * height[rightIndex]);
                rightIndex--;
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int max = 0;
        int length = height.length;
        int leftHeight, rightHeight;
        for (int i = 0; i < length; i++) {
            leftHeight = height[i];
            for (int j = length - 1; j > i; j--) {
                rightHeight = height[j];
                if (rightHeight > leftHeight) {
                    max = Math.max((j - i) * leftHeight, max);
                    break;
                }
                max = Math.max((j - i) * rightHeight, max);
            }
        }
        return max;
    }
}
