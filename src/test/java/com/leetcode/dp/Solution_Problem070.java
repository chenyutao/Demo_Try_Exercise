package com.leetcode.dp;

import org.junit.Test;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Solution_Problem070 {

    private int totalStairNum = 4;

    @Test
    public void test() {
        int i = climbStairs(totalStairNum);
        System.out.println(i);
    }

    /**
     * down
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int val1 = 1;
        int val2 = 2;
        for (int i = 3; i <= n; i++) {
            int a = val2;
            int b = val1 ;
            val1 = val2;
            val2 = a + b ;
        }
        return val2;
    }

}
