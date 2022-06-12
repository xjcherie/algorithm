package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author: Cherie
 * @Date: 2022-06-12
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    private boolean[][] mark;

    public boolean exist(char[][] board, String word) {
        mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int i, int j) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (mark[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        mark[i][j] = true;
        index++;
        if (searchWord(board, word, index, i, j + 1)
                || searchWord(board, word, index, i, j - 1)
                || searchWord(board, word, index, i + 1, j)
                || searchWord(board, word, index, i - 1, j)) {
            return true;
        }
        mark[i][j] = false;
        return false;
    }

    @Test
    public void test() {
        assertThat(exist(
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCCED"
        ), equalTo(true));
    }


}
