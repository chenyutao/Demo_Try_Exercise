package com.leetcode.normal;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author: chenyutao
 * @date: 2021/12/8 9:20 下午
 */
public class Solution_最长公共前缀 {

    @Test
    public void test() {
        String[] strs =  new String[]{"flower","flow","flight"};
        String prefix = longestCommonPrefix(strs);
        System.out.println(prefix);
    }

    /**
     * 20分钟完成，2021.12.08
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs==null ){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int length = strs.length;
        String r = strs[0];
        for(int i=1;i<length;i++){
            r = samePrefix(r,strs[i]);
            if(r==""){
                break;
            }
        }
        return r;
    }

    public String samePrefix(String aa, String bb){
        if(aa==null||aa==""||bb==null||bb==""){
            return "";
        }
        int index = 0;
        // index <= aa.length && index <= bb.length
        while (index < aa.length() && index < bb.length()){
            if(aa.charAt(index)==bb.charAt(index)){
                index++;
            }else{
                break;
            }
        }
        return aa.substring(0,index);
    }

}
