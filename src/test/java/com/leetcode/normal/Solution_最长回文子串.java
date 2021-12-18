package com.leetcode.normal;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author: chenyutao
 * @date: 2021/12/2 9:19 下午
 */
public class Solution_最长回文子串 {

    /**
     * 时间复杂度o(n平方)
     * 双层循环难写，放弃
     */
    public String longestPalindrome2(String s) {
        if(s==null || s.length()<=1){
            return s;
        }
        char[] chars = s.toCharArray();
        String result = chars[0] + "";
        int p=1;
        // 奇数遍历
        for (int i = 1; i < chars.length; i++) {
            int j = Math.min(i,chars.length-i);
            for (int k = 1; k <= j; k++) {
                if(chars[i-k]!=chars[i+k]){
                    break;
                }
                if(k==j){
                    if(result.length()<(j*2+1)){
                        result = s.substring(i-j,i+j);
                    }
                }
            }

        }

        // 偶数遍历


        return "";
    }

    /**
     * 答案
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }




}
