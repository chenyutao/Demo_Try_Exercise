package com.leetcode.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_电话号码的字母组合 {


    @Test
    public void test(){
        List<String> result = letterCombinations("23");
        System.out.println(result);
    }




    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> result  = Arrays.asList("");
        for (int i = 0; i < digits.length(); i++) {
            result = letterCombinations(digits.substring(i),result);
        }
        return result;
    }

    public List<String> letterCombinations(String digits, List<String> list) {
        if(digits.isEmpty()){
            return list;
        }
        char num = digits.charAt(0);
        char[] charArrFromNum = getCharArrFromNum(Integer.parseInt(num+""));
        List<String> newList = new ArrayList<>();
        for (char c : charArrFromNum) {
            for (String s : list) {
                newList.add(s+c);
            }
        }
        return newList;
    }

    public char[] getCharArrFromNum(int num){
        if(num==2){
            return new char[]{'a','b','c'};
        }else if(num==3){
            return new char[]{'d','e','f'};
        }else if(num==4){
            return new char[]{'g','h','i'};
        }else if(num==5){
            return new char[]{'j','k','l'};
        }else if(num==6){
            return new char[]{'m','n','o'};
        }else if(num==7){
            return new char[]{'p','q','r','s'};
        }else if(num==8){
            return new char[]{'t','u','v'};
        }else if(num==9){
            return new char[]{'w','x','y','z'};
        }
        return new char[]{};
    }

}
