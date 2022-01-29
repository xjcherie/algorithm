package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/05
 * 122. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 *  Content: 不限定股票买卖次数，获取最大利润
 *
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

    public int maxProfit1(int[] prices) {
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
