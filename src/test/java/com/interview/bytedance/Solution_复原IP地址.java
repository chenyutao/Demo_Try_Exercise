package com.interview.bytedance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 题库：复原ip地址
 * 完整耗时：60min
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Solution_复原IP地址 {
    /**
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     */
    @Test
    public void test() {
        String s = "101023";
        List<String> strings = restoreIpAddresses(s);
        System.out.println(strings);
    }

    /**
     * 1. 4层的嵌套
     * 2. 字符长度判断
     * 3. 数字范围判断
     */
    public List<String> restoreIpAddresses(String s) {
        if(s==null){
            return new ArrayList<>();
        }
        return restore4IpNode(s);
    }


    public List<String> restore4IpNode(String s) {
        if(s.length()>3*4 || s.length()<1*4){
            return new ArrayList<>();
        }
        List<String> all = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<String> lastNodes;
        // x.
        String num1 = s.substring(0,1);
        String lastStr_1 = s.substring(1);
        lastNodes = restore3IpNode(lastStr_1);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num1+"."+lastNode);
            }
        }
        if(chars[0]=='0'){
            return all;
        }
        // xx.
        String num2 = s.substring(0,2);
        String lastStr_2 = s.substring(2);
        lastNodes = restore3IpNode(lastStr_2);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num2+"."+lastNode);
            }
        }
        // xxx.
        String num3 = s.substring(0,3);
        if(Integer.parseInt(num3)>255){
            return all;
        }
        String lastStr_3 = s.substring(3);
        lastNodes = restore3IpNode(lastStr_3);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num3+"."+lastNode);
            }
        }
        return all;
    }

    public List<String> restore3IpNode(String s) {
        if(s.length()>3*3 || s.length()<1*3){
            return null;
        }
        List<String> all = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<String> lastNodes;
        // x.
        String num1 = s.substring(0,1);
        String lastStr_1 = s.substring(1);
        lastNodes = restore2IpNode(lastStr_1);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num1+"."+lastNode);
            }
        }
        if(chars[0]=='0'){
            return all;
        }
        // xx.
        String num2 = s.substring(0,2);
        String lastStr_2 = s.substring(2);
        lastNodes = restore2IpNode(lastStr_2);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num2+"."+lastNode);
            }
        }
        // xxx.
        String num3 = s.substring(0,3);
        if(Integer.parseInt(num3)>255){
            return all;
        }
        String lastStr_3 = s.substring(3);
        lastNodes = restore2IpNode(lastStr_3);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num3+"."+lastNode);
            }
        }
        return all;
    }

    public List<String> restore2IpNode(String s) {
        if(s.length()>3*2 || s.length()<1*2){
            return null;
        }
        List<String> all = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<String> lastNodes;
        // x.
        String num1 = s.substring(0,1);
        String lastStr_1 = s.substring(1);
        lastNodes = restore1IpNode(lastStr_1);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num1+"."+lastNode);
            }
        }
        if(chars[0]=='0'){
            return all;
        }
        // xx.
        String num2 = s.substring(0,2);
        String lastStr_2 = s.substring(2);
        lastNodes = restore1IpNode(lastStr_2);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num2+"."+lastNode);
            }
        }
        // xxx.
        if(s.length()<3){
            return all;
        }
        String num3 = s.substring(0,3);
        if(Integer.parseInt(num3)>255){
            return all;
        }
        String lastStr_3 = s.substring(3);
        lastNodes = restore1IpNode(lastStr_3);
        if(lastNodes!=null && lastNodes.size()!=0){
            for (String lastNode : lastNodes) {
                all.add(num3+"."+lastNode);
            }
        }
        return all;
    }

    public List<String> restore1IpNode(String s) {
        if(s.length()>3*1 || s.length()<1*1){
            return null;
        }
        char[] chars = s.toCharArray();
        if( chars.length>1 && chars[0]=='0'){
            return null;
        }
        int num = Integer.parseInt(s);
        // todo
        if(num>255){
            return null;
        }
        List<String> all = new ArrayList<>();
        all.add(s);
        return all;
    }


}
