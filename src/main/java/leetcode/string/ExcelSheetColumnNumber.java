package leetcode.string;

/**
 * @Author: Cherie
 * @Date: 2022-09-04
 * <a href="https://leetcode.com/problems/excel-sheet-column-number/">171. Excel Sheet Column Number</a>
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int digit = 0;
        int index = 0;
        for (int length = columnTitle.length() - 1; length >= 0; length--) {
            digit += (columnTitle.charAt(length) - 64) * Math.pow(26, index++);
        }
        return digit;
    }

}
