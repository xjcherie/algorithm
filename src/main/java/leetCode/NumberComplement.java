package leetCode;

/**
 * Created by Cherie on 2020/05/04
 * https://leetcode.com/problems/number-complement/
 **/
public class NumberComplement {
    public int findComplement(int num) {
        String numStr = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
