package practice;

import java.util.Objects;

/**
 * @Author: Cherie
 * @Date: 2022-05-30
 *
 */
public class SearchMax {
    public int max(int hLength, int wLength, String[][] source) {
        int[][] tempArray = this.initSource(hLength, wLength, source);
        if (hLength <= 0 || wLength <= 0) return 0;
        int max = 0;
        for (int i = 1; i < hLength; i++) {
            for (int j = 1; j < wLength; j++) {
                if (tempArray[i][j] != 1) {
                    continue;
                }
                max = Math.max(tempArray[i][j], Math.max(tempArray[i - 1][j - 1], Math.max(tempArray[i][j - 1], tempArray[i - 1][j])));
            }
        }
        return max;
    }

    public int[][] initSource(int hLength, int wLength, String[][] source) {
        int[][] array = new int[hLength][wLength];
        for (int i = 0; i < hLength; i++) {
            for (int j = 0; j < wLength; j++) {
                array[i][j] = Objects.equals(source[i][j], "F") ? 0 : 1;
            }
        }
        return array;
    }

}
