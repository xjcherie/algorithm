package practice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/09/13
 **/
public class MatrixSearch {

    private boolean search(int[][] source, int dest) {
        if (source.length == 0 || source[0].length == 0) return false;

        int hLength = source.length;
        for (int i = (hLength / 2); i < hLength && i >= 0; ) {
            int[] array = source[i];
            int firstDigital = array[0], lastDigital = array[array.length - 1];

            if (dest >= firstDigital && dest <= lastDigital) {
                return this.compare(array, dest);
            } else if (dest < firstDigital) {
                i--;
            } else {
                i++;
            }
        }
        return false;
    }

    private boolean compare(int[] array, int dest) {
        int length = array.length;
        for (int i = (length / 2); i < length && i >= 0; ) {
            int digital = array[i];
            if (dest == digital) {
                return true;
            } else if (dest < digital) {
                i--;
            } else {
                i++;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertThat(
                search(new int[][]{
                                {1, 3, 5, 9},
                                {10, 11, 12, 30},
                                {230, 300, 350, 500}},
                        16),
                equalTo(true)
        );
    }
}
