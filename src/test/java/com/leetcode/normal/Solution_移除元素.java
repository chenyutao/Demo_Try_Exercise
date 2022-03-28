package com.leetcode.normal;

import org.junit.Test;

/**
 * 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author: chenyutao
 * @date: 2021/12/2 1:30 下午
 */
public class Solution_移除元素 {

    @Test
    public void test() {
        int[] nums =  new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int i = removeElement3(nums, val);
    }

    /**
     * 方法一：每次删一个，如此反复
     */
    public int removeElement(int[] nums,int val){
        return 0;
    }

    /**
     * 方法二：双指针
     */
    public int removeElement2(int[] nums,int val){
        return 0;
    }

    /**
     * 方法3：
     */
    public int removeElement3(int[] nums,int val){
        int index = 0;
        int matchCount =0;
        while (index<nums.length){
            int targetIndex = index + matchCount;
            while ( targetIndex < nums.length && nums[targetIndex]==val ){
                matchCount++;
                targetIndex = index + matchCount;
            }
            if(targetIndex < nums.length){
                nums[index]= nums[targetIndex];
            }else {
                nums[index]=0;
            }
            index++;
        }
        return nums.length-matchCount;
    }


}
