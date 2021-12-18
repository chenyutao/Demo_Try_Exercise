package com.leetcode.dp;

import org.junit.Test;

/**
 * 最大子序和
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn3cg3/
 */
public class Solution_20210722 {
    private int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    private int[] nums2 = new int[]{-2, 100, -3, -1, -2, 50};

    @Test
    public void test() {
        int i = maxSubArray2(nums2);
        System.out.println(i);
    }

    /**
     * 错误
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int result = nums[0];
        int backUp = 0;
        for (int i = 1; i < length; i++) {
            int newInt = nums[i];
            if (newInt > 0 && result < 0) {
                result = newInt;
                backUp = 0;
                continue;
            }
            int value1 = result;
            int value2 = result + backUp + newInt;
            if (value2 >= value1) {
                result = value2;
                backUp = 0;
            } else {
                result = value1;
                backUp = backUp + newInt;
            }
        }
        return result;
    }

    /**
     * todo 这个公式的原理，想不明白
     * 不靠谱的参考文档 https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485355&idx=1&sn=17a59704a657b4880dffb54c40ad730e&chksm=9bd7f9a3aca070b53c3f74c9d0a1074ae1e615699fd3b977b8134d486106e62fb28cdf59cb52&scene=178&cur_album_id=1318881141113536512#rd
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
