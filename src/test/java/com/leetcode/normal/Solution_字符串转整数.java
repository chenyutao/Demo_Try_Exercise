package com.leetcode.normal;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 字符串转整数
 */
public class Solution_字符串转整数 {

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        long result = 0;
        boolean de =false;
        boolean start = false;
        int prec = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '-'){
                if(start){
                    break;
                }
                de = true;
                start=true;
                continue;
            }
            if(c == '+'){
                if(start){
                    break;
                }
                de = false;
                start=true;
                continue;
            }
            if(c==' '){
                if(start){
                    break;
                }
                continue;
            }
            int value = c - '0';
            if(value<0 || value>10){
                break;
            }else {
                start=true;
            }
            if(result==0 & value==0){
                continue;
            }
            result = result* 10 + value;
            prec++;
            if(prec>11){
                break;
            }
        }
        if( de){
            result = -result;
        }
        if(result>Integer.MAX_VALUE ){
            result = Integer.MAX_VALUE;
        }else if(result<Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        }
        return (int)result;
    }

}
