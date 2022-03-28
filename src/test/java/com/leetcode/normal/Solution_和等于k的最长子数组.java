package com.leetcode.normal;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k/
 * 题号 325
 *
 * @author: chenyutao
 * @date: 2022/1/22 6:14 下午
 */
public class Solution_和等于k的最长子数组 {
    @Test
    public void test1() {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;
        // target = 4
        System.out.println(maxSubArrayLen(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{-2, -1, 2, 1};
        int k = 1;
        System.out.println(maxSubArrayLen(nums, k));
    }

    public int maxSubArrayLen(int[] nums, int k) {
        int length = nums.length;
        int[] sums = new int[length + 1];
        sums[0] = 0;
        for (int i = 1; i <= length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int maxLen = 0;
        // 没有剪枝思路
        for (int i = 0; i <= length; i++) {
            for (int j = length; j > i; j--) {
                int r = sums[j] - sums[i];
                if (r == k) {
                    int len = j - i;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }


    /**
     * 参考答案
     * 评论：牛批，差值简化
     */
    public int maxSubArrayLen2(int[] nums, int k) {
        //哈希表存储值和下标
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        map.put(0, 0);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int diff = pre[i] - k;
            if (map.containsKey(diff)) {
                max = Math.max(max, i - map.get(diff));
            }
            if (!map.containsKey(pre[i])) {
                map.put(pre[i], i);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

}
