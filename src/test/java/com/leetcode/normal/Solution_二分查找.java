package com.leetcode.normal;

import org.junit.Test;

/**
 * @author: chenyutao
 * @date: 2021/12/22 11:32 下午
 */
public class Solution_二分查找 {

    @Test
    public void test() {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 2;
        int result = search(nums, target);
        System.out.println("result: "+ result);
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length==0){
            return -1;
        }
        if(nums[0]==target){
            return 0;
        }
        if(nums[nums.length-1]==target){
            return nums.length-1;
        }
        if(nums[0]>target||nums[nums.length-1]<target){
            return -1;
        }
        int minIndex = 0;
        int maxIndex = nums.length;
        int midIndex = (minIndex+maxIndex)/2;
        while(true){
            if(nums[midIndex]==target){
                return midIndex;
            }
            if(nums[midIndex]>target){
                maxIndex = midIndex;
            }else{
                minIndex = midIndex;
            }
            int lastMidIndex = midIndex;
            midIndex = (minIndex+maxIndex)/2;
            if(minIndex>=maxIndex  || lastMidIndex == midIndex){
                return -1;
            }
        }
    }
}
