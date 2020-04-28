package leetCode;

import java.util.*;

/**
 * Created by Cherie on 2020/04/28
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/
 * todo
 **/
public class FirstUnique {
    private Map<Integer, Integer> map = new HashMap<>();
    private Queue<Integer> queue = new LinkedList<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (queue.size() > 0) {
            if (map.get(queue.peek()) == 1) {
                return queue.peek();
            }
            queue.poll();
        }
        return -1;
    }

    public void add(int value) {
        queue.add(value);
        map.put(value, map.computeIfAbsent(value, k -> 0) + 1);
    }

}

class FirstUnique1 {

    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public FirstUnique1(int[] nums) {
        for (int num : nums) {
            map.put(num, map.computeIfAbsent(num, k -> 0) + 1);
        }
    }

    public int showFirstUnique() {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public void add(int value) {
        map.put(value, map.computeIfAbsent(value, k -> 0) + 1);
    }
}
