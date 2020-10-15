package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Cherie on 2020/05/10
 * https://leetcode.com/problems/find-the-town-judge/
 **/
public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1) {
            return N;
        }
        if (trust.length < N - 1) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] ints : trust) {
            map.computeIfAbsent(ints[0], k -> new HashSet<>()).add(ints[1]);
            set.add(ints[0]);
            set.add(ints[1]);
        }
        set.removeIf(s -> map.get(s) != null);
        if (set.size() != 1) {
            return -1;
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (!entry.getValue().containsAll(set)) {
                return -1;
            }
        }
        return (int) set.toArray()[0];
    }
}
