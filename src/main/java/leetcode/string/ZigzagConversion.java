package leetcode.string;

/**
 * Created by Cherie on 2022/01/29
 * https://leetcode.com/problems/zigzag-conversion/
 **/
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int length = s.length();
        int count = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += count) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + count - i < length) {
                    sb.append(s.charAt(j + count - i));
                }
            }
        }
        return sb.toString();
    }

}
