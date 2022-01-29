package leetcode.array;

/**
 * Created by Cherie on 2021/04/07
 * 121. https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * Content: 一次股票买卖，获取最大利润
 * Time complexity: O(n).
 * Space complexity: O(1).
 * <p>
 * Opinion: 取最大最小值
 **/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int length = prices.length;
        int buy = prices[0], sell = 0;
        for (int i = 1; i < length; i++) {
            buy = Math.min(prices[i], buy);
            sell = Math.max(prices[i] - buy, sell);
        }
        return sell;
    }

}
