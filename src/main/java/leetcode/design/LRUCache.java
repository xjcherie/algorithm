package leetcode.design;

import java.util.*;

/**
 * Created by Cherie on 2020/04/24
 * https://leetcode.com/problems/lru-cache/
 **/
public class LRUCache {
    private int capacity;

    private LinkedHashMap<Integer, Integer> map;

    private LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
        list = new LinkedList<>();
    }

    public int get(int key) {
        if (map == null) {
            return -1;
        }
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }
        list.removeFirstOccurrence(key);
        list.addFirst(key);
        return value;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            list.removeFirstOccurrence(key);
        } else if (map.size() == capacity) {
            map.remove(list.getLast());
            list.removeLast();
        }
        map.put(key, value);
        list.addFirst(key);
    }
}
