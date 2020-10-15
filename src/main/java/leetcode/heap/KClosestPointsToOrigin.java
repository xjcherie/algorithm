package leetcode.heap;

import java.util.Arrays;

/**
 * Created by Cherie on 2020/05/30
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * todo: 分治算法
 **/
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        int[] distance = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            distance[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        Arrays.sort(distance);

        int max = distance[K - 1], index = 0;
        for (int[] point : points) {
            if (max >= point[0] * point[0] + point[1] * point[1]) {
                ans[index++] = point;
            }
        }
        return ans;
    }

}
