package leetCode;

import leetCode.common.BinaryMatrix;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/21
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
 **/
public class LeftmostColumnWithAtLeastAOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int width = dim.get(0), length = dim.get(1);
        int x = 0, y = length - 1;
        int index = -1;
        while (x < width && y >= 0) {
            if (binaryMatrix.get(x, y) == 0) {
                x++;
            } else {
                index = y--;
            }
            if (index == 0) {
                break;
            }
        }
        return index;
    }

    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int n = list.get(0), m = list.get(1);
        int index = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = index == -1 ? m - 1 : index; j >= 0; j--) {
                if (binaryMatrix.get(i, j) == 0) {
                    break;
                }
                if (index == -1 || j < index) {
                    index = j;
                }
            }
            if (index == 0) {
                break;
            }
        }
        return index;
    }

    @Test
    public void test() {
        assertThat(leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {1, 1}})), equalTo(0));
    }

}
