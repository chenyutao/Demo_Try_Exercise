package com.leetcode.dp;

import org.junit.Test;

/**
 * 打家劫舍
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/
 */
public class Solution_Problem198 {
    private int[] nums1 = new int[]{1, 2, 3, 1};
    private int[] nums2 = new int[]{2, 7, 9, 3, 1};

    @Test
    public void test() {
        int i = rob(nums2);
        System.out.println(i);
    }

    /**
     * down
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int val_0 = 0;
        int val_1 = nums[0];
        int maxVal = 0;
        for (int i = 1; i < nums.length; i++) {
            int f1 = val_1;
            int f2 = val_0 + nums[i];
            if (f2 >= f1) {
                maxVal = f2;
            } else {
                maxVal = f1;
            }
            val_0 = val_1;
            val_1 = maxVal;
        }
        return maxVal;
    }


}
