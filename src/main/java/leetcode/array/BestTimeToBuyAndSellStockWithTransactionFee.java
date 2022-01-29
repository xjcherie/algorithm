package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 重点：边界值
 **/
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;

        int profit = 0, buy = prices[0], length = prices.length;

        for (int i = 1; i < length; i++) {
            int curPrice = prices[i];

            buy = Math.min(buy, curPrice);
            if (buy > curPrice - fee) {
                continue;
            }

            boolean canSell = true;
            for (int m = i + 1; m < length; m++) {
                int price = prices[m];
                if (price < curPrice - fee) {
                    break;
                }
                if (price >= curPrice) {
                    canSell = false;
                    break;
                }
            }
            if (canSell) {
                profit += curPrice - fee - buy;
                buy = Integer.MAX_VALUE;
            }
        }
        return profit;
    }

    @Test
    public void test() {
        assertThat(maxProfit(new int[]{2, 2, 1, 1, 5, 5, 3, 1, 5, 4}, 2), equalTo(4));
    }

}
