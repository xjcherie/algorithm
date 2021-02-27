package leetcode.amber2021;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/01/12
 * https://leetcode.com/problems/course-schedule/
 * 提示：只要数字间，不存在环即可
 **/
public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return true;
    }

    @Test
    public void test() {
        assertThat(canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 0}}), equalTo(false));
        assertThat(canFinish(2, new int[][]{{0, 1}}), equalTo(true));
        assertThat(canFinish(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}), equalTo(true));
    }

}
