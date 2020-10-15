package leetcode.graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/31
 * https://leetcode.com/problems/course-schedule/
 **/
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[0], k -> new HashSet<>()).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> requireSet = map.get(i);
            if (requireSet == null || set.containsAll(requireSet) || this.check(i, map, 0, numCourses)) {
                set.add(i);
                map.remove(i);
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean check(int k, Map<Integer, Set<Integer>> map, int count, int numCourses) {
        if (count == numCourses) {
            return false;
        }
        Set<Integer> requireSet = map.get(k);
        if (requireSet == null) {
            return true;
        }
        count++;
        for (Integer integer : requireSet) {
            if (!check(integer, map, count, numCourses)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 0}}), equalTo(false));
        assertThat(canFinish(2, new int[][]{{0, 1}}), equalTo(true));
    }

}
