package com.interview.huawei;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 模拟内存分配
 *
 * @author: chenyutao
 * @date: 2021/12/28 9:40 下午
 */
public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rowsStr = sc.nextLine();
        int rows = Integer.parseInt(rowsStr);
        String[] reqs = new String[rows];
        for (int i = 0; i < rows; i++) {
            reqs[i] = sc.nextLine();
        }
        cal(reqs);
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("REQUEST=80");
//        list.add("REQUEST=20");
        list.add("RELEASE=0");
        list.add("REQUEST=20");
        list.add("REQUEST=10");
        cal(list.toArray(new String[0]));
    }

    public static void cal(String[] reqs){
        for (String req : reqs) {
            execute(req);
        }
    }

    public static void execute(String req){
        if(req.startsWith("REQUEST=")){
            String numStr = req.substring(8);
            int num = Integer.parseInt(numStr);
            acquire(num);
        }else if(req.startsWith("RELEASE=")){
            String numStr = req.substring(8);
            int num = Integer.parseInt(numStr);
            release(num);
        }

    }

    private static int maxSize = 100;
    private static int[] markArr = new int[maxSize];

    public static void acquire(int num){
        if(num==0){
            System.out.println("error");
            return;
        }
        for (int i = 0; i <= maxSize-num; i++) {
            if(markArr[i]!=0){
                continue;
            }
            boolean failThis = false;
            for (int j = 0; j < num; j++) {
                if(markArr[i+j]!=0){
                    failThis = true;
                    break;
                }
            }
            if(!failThis){
                markArr[i]=1;
                for (int j = 1; j < num; j++) {
                    markArr[i+j]=2;
                }
                System.out.println(i);
                return;
            }
        }
        System.out.println("error");
    }

    public static void release(int num){
        if(markArr[num]!=1){
            System.out.println("error");
            return;
        }
        markArr[num] = 0;
        int index = num+1;
        while (index<maxSize && markArr[index]==2){
            markArr[index]=0;
            index++;
        }
    }

}
