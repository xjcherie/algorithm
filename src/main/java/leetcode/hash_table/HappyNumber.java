package leetcode.hash_table;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/02
 * https://leetcode.com/problems/happy-number/
 **/
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int ans = 0;
            while (n > 0) {
                ans += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = ans;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public boolean isHappy1(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = HappySq(slow);
            fast = HappySq(HappySq(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int HappySq(int n) {
        int num = 0;
        while (n != 0) {
            num += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return num;
    }

    @Test
    public void test() {
        assertThat(isHappy(19), equalTo(true));
        assertThat(isHappy(2), equalTo(false));
    }

}
