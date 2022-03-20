package leetcode;

/**
 * Created by Cherie on 2022/03/20
 * https://leetcode.com/problems/sqrtx/
 **/
public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        int digit = 1;
        while ((long) digit * digit <= x) {
            digit++;
        }
        return digit - 1;
    }
}
