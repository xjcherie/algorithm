package leetcode.amber2021.february;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/02/19
 * https://leetcode.com/problems/valid-sudoku/
 **/
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> set1, set2, set3;
        char num1, num2, num3;

        for (int i = 0; i < 9; i++) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                num1 = board[j][i];
                if (num1 != '.') {
                    if (set1.contains(num1)) {
                        return false;
                    }
                    set1.add(num1);
                }

                num2 = board[i][j];
                if (num2 != '.') {
                    if (set2.contains(num2)) {
                        return false;
                    }
                    set2.add(num2);
                }

                if (i % 3 != 0 || j % 3 != 0) continue;

                set3 = new HashSet<>();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        num3 = board[m + i][n + j];
                        if (num3 == '.') {
                            continue;
                        }
                        if (set3.contains(num3)) {
                            return false;
                        }
                        set3.add(num3);
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(isValidSudoku(
                new char[][]{
                        new char[]{'.', '.', '5', '.', '.', '.', '.', '.', '6'},
                        new char[]{'.', '.', '.', '.', '1', '4', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '9', '2', '.', '.'},
                        new char[]{'5', '.', '.', '.', '.', '2', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '3', '.'},
                        new char[]{'.', '.', '.', '5', '4', '.', '.', '.', '.'},
                        new char[]{'3', '.', '.', '.', '.', '.', '4', '2', '.'},
                        new char[]{'.', '.', '.', '2', '7', '.', '6', '.', '.'}
                }
        ), equalTo(true));
    }

}
