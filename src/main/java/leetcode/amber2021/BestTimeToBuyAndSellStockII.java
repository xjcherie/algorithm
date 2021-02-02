package leetcode.amber2021;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/01/19
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 **/
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int leftIndex, rightIndex, index = 0;
        int length = prices.length;

        while (index < length) {
            leftIndex = index;
            while (index < length && prices[leftIndex] >= prices[index]) {
                leftIndex = index;
                index++;
            }
            rightIndex = leftIndex;
            while (index < length && prices[rightIndex] <= prices[index]) {
                rightIndex = index;
                index++;
            }
            if (leftIndex == rightIndex) {
                index++;
            }

            profit += Math.max(0, prices[rightIndex] - prices[leftIndex]);
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
