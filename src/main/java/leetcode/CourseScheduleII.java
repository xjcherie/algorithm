package leetcode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/23
 * https://leetcode.com/problems/course-schedule-ii/
 * todo:
 **/
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            preMap.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (set.contains(i)) {
                continue;
            }
            HashSet<Integer> relationSet = new HashSet<>();
            if (this.checkCircle(preMap, set, relationSet, i)) {
                return new int[0];
            }
            set.add(i);
        }
        return set.stream().mapToInt(i -> i).toArray();
    }

    private boolean checkCircle(Map<Integer, List<Integer>> preMap, LinkedHashSet<Integer> set, HashSet<Integer> relationSet, Integer course) {
        List<Integer> nextCourses = preMap.get(course);
        if (nextCourses == null) {
            return false;
        }
        relationSet.add(course);
        for (Integer next : nextCourses) {
            if (set.contains(next)) {
                continue;
            }
            if (relationSet.contains(next)) {
                return true;
            }
            relationSet.add(next);
            if (this.checkCircle(preMap, set, relationSet, next)) {
                return true;
            }
            set.add(next);
        }
        return false;
    }

    @Test
    public void test() {
        assertThat(findOrder(3,
                new int[][]{
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 2}
                }), equalTo(new int[]{2, 1, 0}));
    }

}
