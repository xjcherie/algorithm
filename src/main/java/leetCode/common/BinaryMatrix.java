package leetCode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2020/04/21
 **/
public class BinaryMatrix {
    private int[][] matrix;

    public BinaryMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int get(int x, int y) {
        return matrix[x][y];
    }

    public List<Integer> dimensions() {
        List<Integer> list = new ArrayList<>();
        list.add(matrix.length);
        list.add(matrix[0].length);
        return list;
    }
}
