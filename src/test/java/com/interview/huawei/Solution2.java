package com.interview.huawei;


import org.junit.Test;

import java.util.Scanner;

/**
 * 字符串匹配
 *
 * @author: chenyutao
 * @date: 2021/12/28 9:40 下午
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(cal(str1,str2));
    }

    @Test
    public void test() {
        int result = cal("abc", "abcabcaabbcc");
        System.out.println(result);
    }

    public static int cal(String str1, String str2){
        int result = -1;
        int j = str2.length()-1;
        for (int i = str1.length()-1; i >= 0 ; i--) {
            char c1 = str1.charAt(i);
            boolean matchMark = false;
            for (; j >=0 ; j--) {
                char c2 = str2.charAt(j);
                if(c1==c2){
                    matchMark = true;
                    j--;
                    break;
                }
            }
            if(matchMark && i==0 ){
                j++;
                result=j;
            }
        }
        return result;
    }

}
