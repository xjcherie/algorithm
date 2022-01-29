package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/04/07
 * 123. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * <p>
 * Content: 最多可以进行两次股票买卖，获取最大利润
 **/
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = prices[0], sell1 = 0;
        int buy2 = prices[0], sell2 = 0;
        for (int i = 1; i < n; i++) {
            int curPrice = prices[i];
            buy1 = Math.min(buy1, curPrice);
            sell1 = Math.max(sell1, curPrice - buy1);
            buy2 = Math.min(buy2, curPrice - sell1);
            sell2 = Math.max(sell2, curPrice - buy2);

            System.out.println(i + ": " + buy1 + ", " + sell1 + ", " + buy2 + ", " + sell2);
        }
        return sell2;
    }

    public int maxProfit1(int[] prices) {
        int length = prices.length;
        int[][] profitArray = new int[length][2];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > 0) {
                    profitArray[i][0] = Math.max(profitArray[i][0], profit);
                    profitArray[j][1] = Math.max(profitArray[j][1], profit);
                }
            }
        }

        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            maxProfit = Math.max(maxProfit, profitArray[i][0]);
            for (int j = i + 1; j < length; j++) {
                maxProfit = Math.max(maxProfit, profitArray[i][1] + profitArray[j][0]);
            }
        }
        return maxProfit;
    }

    @Test
    public void test() {
        assertThat(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}), equalTo(6));
    }

}
