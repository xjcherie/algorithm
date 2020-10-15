package leetcode.depth_first_search;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/11
 * https://leetcode.com/problems/flood-fill/
 * todo：哪种情况下出现死循环
 **/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        this.fillNewColor(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fillNewColor(int[][] image, int i, int j, int color, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color) {
            return;
        }
        if (image[i][j] == newColor) {
            return;
        }
        image[i][j] = newColor;
        fillNewColor(image, i - 1, j, color, newColor);
        fillNewColor(image, i + 1, j, color, newColor);
        fillNewColor(image, i, j - 1, color, newColor);
        fillNewColor(image, i, j + 1, color, newColor);
    }

    @Test
    public void test() {
        assertThat(
                floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2),
                equalTo(new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}})
        );
        assertThat(
                floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2),
                equalTo(new int[][]{{2, 2, 2}, {2, 2, 2}})
        );
        assertThat(
                floodFill(new int[][]{{0, 1, 0}, {0, 0, 0}}, 0, 0, 2),
                equalTo(new int[][]{{2, 1, 2}, {2, 2, 2}})
        );
    }
}
