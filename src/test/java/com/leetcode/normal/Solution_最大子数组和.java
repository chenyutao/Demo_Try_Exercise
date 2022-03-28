package com.leetcode.normal;

import org.junit.Test;

/**
 * @author: chenyutao
 * @date: 2022/1/13 9:56 下午
 *
 * 解法：
 * step1. 重新定义 dp 数组的含义：以 nums[i] 为结尾的「最大子数组和」为 dp[i]。
 * step2. 遍历数组dp 取最大值
 */
public class Solution_最大子数组和 {

    @Test
    public void test1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // target: 6
        System.out.println(maxSubArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{5, 4, -1, 7, 8};
        // target: 23
        System.out.println(maxSubArray(nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{8,-19,5,-4,20};
        // target: -1
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] resultArr = new int[nums.length];
        int startIndex =0;
        int endIndex =0;
        resultArr[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if(val<0 ){
                if(val>=resultArr[i-1]){
                    startIndex = i;
                    endIndex = i;
                    resultArr[i]= val;
                    continue;
                }else {
                    resultArr[i]= resultArr[i-1];
                    continue;
                }
            }
            if(resultArr[i-1]<0){
                startIndex = i;
                endIndex = i;
                resultArr[i]= val;
                continue;
            }
            int mid = 0;
            for (int j = endIndex+1; j < i; j++) {
                mid+=nums[j];
            }
            // mid必然小于0
            if( (mid+resultArr[i-1]) < 0){
                if((mid+val)<0){
                    resultArr[i]= resultArr[i-1];
                }else {
                    startIndex = i;
                    endIndex = i;
                    resultArr[i]= val;
                }
            }else if((mid+val)<0) {
                resultArr[i]= resultArr[i-1];
            }else {
                endIndex = i;
                resultArr[i]=resultArr[i-1]+mid+val;
            }
        }
        return resultArr[nums.length-1];
    }

}
