package leetcode.array;

/**
 * Created by Cherie on 2022/04/03
 * https://leetcode.com/problems/merge-sorted-array/
 **/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[length] = nums1[m];
                    m--;
                } else {
                    nums1[length] = nums2[n];
                    n--;
                }
            } else if (m >= 0) {
                nums1[length] = nums1[m];
                m--;
            } else {
                nums1[length] = nums2[n];
                n--;
            }
            length--;
        }
    }
}
