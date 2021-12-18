package com.leetcode.normal;

import org.junit.Assert;
import org.junit.Test;

/**
 * int数值翻转
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author: chenyutao
 * @date: 2021/11/29 1:22 下午
 */
public class Solution_整数反转 {

    @Test
    public void test1() {
        int result = reverse(123);
        Assert.assertEquals(321, result);
    }

    @Test
    public void test2() {
        int result = reverse(-123);
        Assert.assertEquals(-321, result);
    }

    @Test
    public void test3() {
        int result = reverse(120);
        Assert.assertEquals(21, result);
    }

    @Test
    public void test4() {
        int result = reverse(0);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test5() {
        int result = reverse(-2147483648);
        Assert.assertEquals(0, result);
    }


    /**
     * 为了防止越界，用除法做大小判断
     */
    /**
     * 答案1， 仅限Java
     */
    public int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = res * 10 + x % 10;
            if (tmp / 10 != res) { // 溢出!!!
                return 0;
            }
            res = tmp;
            x /= 10;
        }
        return res;
    }


    /**
     * 答案2，fail  todo
     */
    public int reverse(int x) {
        boolean flag = x>0;
        int val = flag?x:-x;
        char[] chars = String.valueOf(val).toCharArray();
        int result = 0;
        for (int i = chars.length-1; i > 0; i--) {
            result = result*10 + (chars[i]-'0');
        }
        if(result>Integer.MAX_VALUE/10){
            return 0;
        }
        if(result==Integer.MAX_VALUE/10 ){
            if(flag && (chars[0]-'0')>Integer.MAX_VALUE%10){
                return 0;
            }else if (!flag && (chars[0]-'0')>Integer.MIN_VALUE%10){
                return 0;
            }
            }
        result =  result*10 + (chars[0]-'0');
        if(!flag){
            result= -result;
        }
        return result;
    }



}
