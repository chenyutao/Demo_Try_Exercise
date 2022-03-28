package com.leetcode.normal;

import org.junit.Test;

public class Solution_比较版本号 {

    @Test
    public void test(){
        String version1= "0.1";
        String version2="1.1";
        int compare = compareVersion(version1, version2);
        System.out.println(compare);
    }

    // start time 21:22
    public int compareVersion(String version1, String version2) {
        if(version1.isEmpty() && version2.isEmpty()){
            return 0;
        }else if(version1.isEmpty()){
            return -1;
        }else if(version2.isEmpty()){
            return 1;
        }
        String[] s1 = version1.split("[.]");
        String[] s2 = version2.split("[.]");
        int min = Math.min(s1.length,s2.length);
        for(int i= 0;i<min;i++){
            int v1 = Integer.parseInt(s1[i]);
            int v2 = Integer.parseInt(s2[i]);
            if(v1>v2){
                return 1;
            }else if(v1 < v2){
                return -1;
            }
        }
        if(s1.length==s2.length){
            return 0;
        }
        if(s1.length>s2.length){
            for(int i= s2.length;i<s1.length;i++){
                int v1 = Integer.parseInt(s1[i]);
                if(v1!=0){
                    return 1;
                }
            }
        }
        if(s1.length<s2.length){
            for(int i= s1.length;i<s2.length;i++){
                int v2 = Integer.parseInt(s2[i]);
                if(v2!=0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
