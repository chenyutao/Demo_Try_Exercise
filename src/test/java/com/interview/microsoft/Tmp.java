package com.interview.microsoft;

import org.junit.Test;

import java.util.*;

/**
 * @author: chenyutao
 * @date: 2022/1/26 10:05 上午
 */
public class Tmp {
    // n 个橘子，分成 k 堆；所有解法
//     10  ,3
//    {2,3,5},{5,4,1}.......

    @Test
    public void test() {
        int n = 11;
        int k = 3;
        List<List<Integer>> result = partitionAll(n, k);
        System.out.println(result);
    }

    public List<List<Integer>> partitionAll(int n,int k){
        if(n<k){
            return null;
        }
        if(k==1){
            return Collections.singletonList(Collections.singletonList(n));
        }
        Map<String,List<Integer>> resultMap = new HashMap<>();
        ArrayList<Integer> front = new ArrayList<>();
        this.partitionAll(n,k, front,resultMap);
        return new ArrayList<>(resultMap.values());
    }

    public void partitionAll(int n,int k,List<Integer> front, Map<String,List<Integer>> resultMap){
        // 分完
        if(k==0&& n==0){
            judge(front,resultMap);
            return;
        }
        // 分错了，橘子不够/堆数不够
        if(k==0 || n==0){
            return;
        }
        if(n<k){
            return;
        }
        if(k==1){
            List<Integer> tmpFront = new ArrayList<>(front);
            tmpFront.add(n);
            partitionAll(0,0,tmpFront,resultMap);
        }
        for (int i = 1; i < n; i++) {
            List<Integer> tmpFront = new ArrayList<>(front);
            tmpFront.add(i);
            partitionAll(n-i,k-1,tmpFront,resultMap);
        }
    }

    private void judge(List<Integer> front,Map<String,List<Integer>> resultMap){
        StringBuilder tmpStr = new StringBuilder();
        front.sort(Integer::compareTo);
        for (Integer val : front) {
            tmpStr.append(val).append("-");
        }
        String key = tmpStr.toString();
        if(!resultMap.containsKey(key)){
            resultMap.put(key,front);
        }
    }

}
