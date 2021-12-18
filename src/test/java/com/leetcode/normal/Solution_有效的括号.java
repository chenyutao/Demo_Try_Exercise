package com.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/submissions/
 *
 * @author: chenyutao
 * @date: 2021/12/9 11:13 下午
 */
public class Solution_有效的括号 {

    /**
     * done
     */
    public boolean isValid(String s) {
        if(s==null || s.length()==0){
            return true;
        }
        List<Integer> stack = new ArrayList<>(s.length());
        int curr = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.add(1);
                curr++;
                continue;
            }else if(c=='{'){
                stack.add(2);
                curr++;
                continue;
            }else if(c=='['){
                stack.add(3);
                curr++;
                continue;
            }
            if(curr==0){
                return false;
            }
            int stackTop = stack.get(curr-1);
            int val = 0;
            if(c==')'){
                val =1;
            }else if(c=='}'){
                val =2;
            }else if(c==']'){
                val =3;
            }
            if(val!=stackTop){
                return false;
            }else{
                stack.remove(curr-1);
                curr--;
            }
        }
        if(curr==0){
            return true;
        }else{
            return false;
        }
    }
}
