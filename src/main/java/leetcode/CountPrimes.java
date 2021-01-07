package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/12/04
 * https://leetcode.com/problems/count-primes/
 **/
public class CountPrimes {

    public int countPrimes(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            result += flag ? 1 : 0;
        }
        return result;
    }

    public int countPrimes1(int n) {
        int[] isPrimes = new int[n];
        Arrays.fill(isPrimes, 1);

        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i] == 0) {
                continue;
            }
            result++;
            if ((long) i * i >= n) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isPrimes[j] = 0;
            }
        }
        return result;
    }

    @Test
    public void test() {
        assertThat(countPrimes(10), equalTo(4));
    }
}
