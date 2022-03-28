package com.interview.microsoft;

/**
 * @author: chenyutao
 * @date: 2022/1/19 10:08 下午
 */
public class Solution1 {
    public int[] solution(int N) {
        // write your code in Java SE 8
        if(N%2==0){
            return newResultForTwo(N);
        }else{
            int[] part = newExtResultForOne(N);
            part[part.length-1]=0;
            return part;
        }
    }

    private int[] newResultForTwo(int N){
        int[] ints = new int[N];
        int index = 0;
        for (int i = 1; i <= N/2; i++) {
            ints[index]=i;
            ints[index+1]=-i;
            index=index+2;
        }
        return ints;
    }

    private int[] newExtResultForOne(int N){
        int[] ints = new int[N];
        int index = 0;
        for (int i = 1; i <= N/2; i++) {
            ints[index]=i;
            ints[index+1]=-i;
            index=index+2;
        }
        return ints;
    }
}
