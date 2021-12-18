package com.leetcode.normal;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/comments/
 * 最长不重复子串
 *
 */
public class Solution_最长不重复子串 {

    private String paramsStr ="abba";
    @Test
    public void test() {
        boolean b = paramsStr.charAt(1) == paramsStr.charAt(2);
        int length = lengthOfLongestSubstring(paramsStr);
        System.out.println(length);
    }


    /**
     * 动态规划
     * 与"股票时机"那道题类似；但是那道题可以画图，更容易想明白
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int[] lastIndexMap = new int[200];
        Arrays.fill(lastIndexMap, -1);
        char[] chars = s.toCharArray();
        int minNoRepeatStartCharIndexToLeastChar = 0;
        int longestNoRepeatStrLenToLeastChar = 0;
        int longestNoRepeatStrLen = 0;
        for (int i = 0; i < chars.length; i++) {
            int charsetId = chars[i]-'0';
            if(lastIndexMap[charsetId]==-1) {
                // minNoRepeatStartCharIndexToLeastChar 不变
                longestNoRepeatStrLenToLeastChar++;
            }else {
                minNoRepeatStartCharIndexToLeastChar = Math.max(minNoRepeatStartCharIndexToLeastChar,lastIndexMap[charsetId]+1);
                longestNoRepeatStrLenToLeastChar = i-minNoRepeatStartCharIndexToLeastChar+1;
            }
            lastIndexMap[charsetId]=i;
            longestNoRepeatStrLen = Math.max(longestNoRepeatStrLen,longestNoRepeatStrLenToLeastChar);
        }
        return longestNoRepeatStrLen;
    }

}
