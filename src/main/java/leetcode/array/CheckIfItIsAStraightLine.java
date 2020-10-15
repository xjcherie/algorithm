package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/08
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 **/
public class CheckIfItIsAStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates[0][1] == coordinates[1][1]) {
            for (int[] coordinate : coordinates) {
                if (coordinate[1] != coordinates[0][1]) {
                    return false;
                }
            }
            return true;
        }
        float k = (float) (coordinates[1][0] - coordinates[0][0]) / (coordinates[1][1] - coordinates[0][1]);
        for (int i = 2; i < coordinates.length; i++) {
            if ((float) (coordinates[i][0] - coordinates[0][0]) / (coordinates[i][1] - coordinates[0][1]) != k) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(
                checkStraightLine(new int[][]{{4, 8}, {-2, 8}, {1, 8}, {8, 8}, {-5, 8}, {0, 8}, {7, 8}, {5, 8}}),
                equalTo(true)
        );
    }
}
