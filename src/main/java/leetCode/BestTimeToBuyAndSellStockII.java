package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/05
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 **/
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int index = 0, profit = 0;
        while (index < prices.length) {
            int large = index + 1;
            while (large < prices.length) {
                if (prices[large] <= prices[index]) {
                    break;
                }
                if (large + 1 == prices.length || prices[large] >= prices[large + 1]) {
                    profit += prices[large] - prices[index];
                    large++;
                    break;
                } else {
                    large++;
                }
            }
            index = large;
        }
        return profit;
    }

    @Test
    public void test() {
        assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4}), equalTo(7));
        assertThat(maxProfit(new int[]{1, 2, 3, 4, 5}), equalTo(4));
        assertThat(maxProfit(new int[]{7, 6, 4, 3, 1}), equalTo(0));
        assertThat(maxProfit(new int[]{6, 1, 3, 2, 4, 7}), equalTo(7));
    }
}
