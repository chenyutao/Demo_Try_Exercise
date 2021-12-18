package com.leetcode.normal;

import org.junit.Assert;
import org.junit.Test;

/**
 *  Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/comments/
 *
 * @author: chenyutao
 * @date: 2021/11/29 11:35 上午
 */
public class Solution_Z字形变换 {

    @Test
    public void test1() {
        String result = convert("PAYPALISHIRING", 3);
        Assert.assertEquals("PAHNAPLSIIGYIR",result);
    }

    @Test
    public void test2() {
        String result = convert("PAYPALISHIRING", 4);
        Assert.assertEquals("PINALSIGYAHRPI",result);
    }

    @Test
    public void test3() {
        String result = convert("A", 1);
        Assert.assertEquals("A",result);
    }

    /**
     * 高效解答： 直接算规律
     */

    /**
     * 按题述，先排一遍
     */
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[] str = s.toCharArray();
        char[][] target = new char[numRows][str.length];
        // true 表示向下，false表示向上
        boolean downDirection = true;
        int index = 0;
        int i=0;
        int j=0;
        while (index<str.length){
            target[i][j]= str[index];
            index++;
            if(i== target.length -1){
                downDirection = false;
            }else if(i== 0){
                downDirection = true;
            }
            if(downDirection){
                i++;
            }else {
                i--;
                j++;
            }
        }
        StringBuilder newStr = new StringBuilder();
        char[] tmp = new char[1];
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < str.length; l++) {
                if(target[k][l]!=tmp[0]){
                    newStr.append(target[k][l]);
                }
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        char[][] target = new char[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                    System.out.println(target[i][j]);
            }
        }

    }



}
