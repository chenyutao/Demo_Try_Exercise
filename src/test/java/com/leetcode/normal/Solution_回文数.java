package com.leetcode.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文int值
 * https://leetcode-cn.com/problems/palindrome-number/
 * @author: chenyutao
 * @date: 2021/11/30 10:38 上午
 */
public class Solution_回文数 {

    @Test
    public void test() {
        boolean result = isPalindrome(12321);
        System.out.println(result);
    }


    /**
     * 方案1：转String
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        List<Integer> nums = new ArrayList<>();
        int y = x;
        while (y!=0){
            nums.add(y%10);
            y = y/10;
        }
        int index1 = 0;
        int index2 = 0;
        if(nums.size()%2==0){
            index1 = nums.size()/2-1;
            index2 = index1+1;
        }else {
            index1 = (nums.size()-1)/2;
            index2 = index1;
        }
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i <= index1; i++) {
            val1 = val1*10+ nums.get(i);
        }
        for (int i = nums.size()-1; i >= index2; i--) {
            val2 = val2*10+ nums.get(i);
        }
        return val1==val2;
    }



}
