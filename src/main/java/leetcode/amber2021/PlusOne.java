package leetcode.amber2021;

import java.util.Arrays;

/**
 * Created by Cherie on 2021/02/04
 * https://leetcode.com/problems/plus-one/
 **/
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int num = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + num;
            result[i + 1] = sum % 10;
            num = sum / 10;
        }
        if (num > 0) {
            result[0] = num;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, result.length);
        }
    }

}
