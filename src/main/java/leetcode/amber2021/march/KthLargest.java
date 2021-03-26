package leetcode.amber2021.march;

import java.util.PriorityQueue;

/**
 * Created by Cherie on 2021/03/24
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 **/
public class KthLargest {

    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.remove();
        }
        return queue.peek();
    }

}
