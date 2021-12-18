package com.leetcode.dp;

import org.junit.Test;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution_Problem121 {
    private int[] nums1 = new int[]{7, 1, 5, 3, 6, 4};
    private int[] nums2 = new int[]{7, 6, 4, 3, 1};

    @Test
    public void test() {
        int i = maxProfit(nums2);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] minPoint = new int[length];
        int[] linkIncome = new int[length];
        int[] maxIncome = new int[length];
        minPoint[0] = prices[0];
        linkIncome[0] = 0;
        maxIncome[0] = 0;

        for (int i = 1; i < length; i++) {
            minPoint[i] = Math.min(minPoint[i-1],prices[i]);
            linkIncome[i] = Math.max(prices[i]-minPoint[i],0);
            maxIncome[i] = Math.max(linkIncome[i],maxIncome[i-1]);
        }
        return maxIncome[length-1];
    }

    /**
     * down
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        int lastMinPoint = prices[0];
        int lastMaxIncome = 0;

        for (int i = 1; i < length; i++) {
            lastMinPoint = Math.min(lastMinPoint,prices[i]);
            lastMaxIncome = Math.max(prices[i]-lastMinPoint,lastMaxIncome);
        }
        return lastMaxIncome;
    }

}
