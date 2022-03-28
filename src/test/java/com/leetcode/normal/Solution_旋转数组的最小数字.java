package com.leetcode.normal;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author: chenyutao
 * @date: 2022/1/5 9:40 下午
 */
public class Solution_旋转数组的最小数字 {
    @Test
    public void test() {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(minArray(nums));
    }

    public int minArray(int[] numbers) {
        if(numbers.length==1){
            return numbers[0];
        }
        for (int i = 0; i <= numbers.length - 2; i++) {
            if(numbers[i]>numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }


}
