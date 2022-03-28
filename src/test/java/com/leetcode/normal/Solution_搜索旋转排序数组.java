package com.leetcode.normal;

import org.junit.Test;

/**
 * @author: chenyutao
 * @date: 2022/1/25 9:26 下午
 */
public class Solution_搜索旋转排序数组 {

    @Test
    public void test() {
        int[] nums =new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search2(nums,target));

    }

    /**
     * 方案1： 遍历
     */
    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 方案2： 2次折半
     */
    public int search2(int[] nums, int target) {
        if (nums.length==1){
            if(nums[0]==target){
                return 0;
            }else {
                return -1;
            }
        }
        int position = findPosition(nums, 0, nums.length);
        if(nums[position]==target){
            return position;
        }
        if(nums[position]>target){
            return -1;
        }else if(position!=0&& nums[position-1]<target){
            return -1;
        }
        if(nums[0]<target){
            findTarget(nums,0,position-1,target);
        }else if(nums[nums.length-1]>target){
            findTarget(nums,position+1,nums.length-1,target);
        }
        return 0;
    }

    private int findPosition(int[] nums,int startIndex,int endIndex){
        int mid = (startIndex+endIndex)/2;
        if(mid==0|| nums[mid]<nums[mid-1]){
            return mid;
        }else {
            if(mid<nums[startIndex]){
                return findPosition(nums,startIndex,mid);
            }else {
                return findPosition(nums,mid,endIndex);
            }
        }
    }

    private int findTarget(int[] nums,int startIndex,int endIndex,int target){
        if(startIndex==endIndex){
            return -1;
        }
        int mid = (startIndex+endIndex)/2;
        if(target==nums[mid]){
            return mid;
        }
        if(target>nums[mid]){
            return findTarget(nums,mid,endIndex,target);
        }else {
            return findTarget(nums,startIndex,mid,target);
        }
    }


}
