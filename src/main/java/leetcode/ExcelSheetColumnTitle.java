package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cherie on 2023/12/17
 * <a href="https://leetcode.com/problems/excel-sheet-column-title/">168. Excel Sheet Column Title</a>
 **/
public class ExcelSheetColumnTitle {

    private static final Map<Integer, Character> letterMap = new HashMap<>();

    static {
        letterMap.put(1, 'A');
        letterMap.put(2, 'B');
        letterMap.put(3, 'C');
        letterMap.put(4, 'D');
        letterMap.put(5, 'E');
        letterMap.put(6, 'F');
        letterMap.put(7, 'G');
        letterMap.put(8, 'H');
        letterMap.put(9, 'I');
        letterMap.put(10, 'J');
        letterMap.put(11, 'K');
        letterMap.put(12, 'L');
        letterMap.put(13, 'M');
        letterMap.put(14, 'N');
        letterMap.put(15, 'O');
        letterMap.put(16, 'P');
        letterMap.put(17, 'Q');
        letterMap.put(18, 'R');
        letterMap.put(19, 'S');
        letterMap.put(20, 'T');
        letterMap.put(21, 'U');
        letterMap.put(22, 'V');
        letterMap.put(23, 'W');
        letterMap.put(24, 'X');
        letterMap.put(25, 'Y');
        letterMap.put(26, 'Z');
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int reminder = columnNumber % 26;
            columnNumber = columnNumber / 26;
            if (reminder == 0) {
                sb.append(letterMap.get(26));
                columnNumber = columnNumber - 1;
                if (columnNumber > 1 && columnNumber < 26) {
                    sb.append(letterMap.get(columnNumber));
                    break;
                }
            } else {
                sb.append(letterMap.get(reminder));
            }
            if (columnNumber == 0) {
                break;
            } else if (columnNumber < 26) {
                sb.append(letterMap.get(columnNumber));
                break;
            }
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("BAQTZ", convertToTitle(943566));
        Assert.assertEquals("A", convertToTitle(1));
        Assert.assertEquals("FXSHRXW", convertToTitle(2147483647));
        Assert.assertEquals("AB", convertToTitle(28));
        Assert.assertEquals("Z", convertToTitle(26));
    }
}
