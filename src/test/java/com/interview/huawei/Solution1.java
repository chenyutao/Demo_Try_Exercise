package com.interview.huawei;


import org.junit.Test;

import java.util.*;

/**
 * 最小数组对
 *
 * @author: chenyutao
 * @date: 2021/12/28 9:40 下午
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        List<Integer> arr1 = new ArrayList<>();
        for(int i = 0; i < size1; i++){
            arr1.add(sc.nextInt());
        }
        int size2 = sc.nextInt();
        List<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i < size2; i++){
            arr2.add(sc.nextInt());
        }
        int k = sc.nextInt();
        int result = cal(arr1, arr2, k);
        System.out.println(result);
    }

    @Test
    public void test() {
        List<Integer> arr1 = Arrays.asList(1, 1, 2);
        List<Integer> arr2 = Arrays.asList(1, 2, 3);
        int k = 2;
        int result = cal(arr1, arr2, k);
        System.out.println(result);
    }

    private static int cal(List<Integer> arr1,List<Integer> arr2,int k){
        List<Integer> pair = new ArrayList<>();
        int k1 = Math.min(k, arr1.size());
        int k2 = Math.min(k, arr2.size());
        for (int i = 0; i < k1; i++) {
            for (int j = 0; j < k2; j++) {
                pair.add(arr1.get(i)+arr2.get(j));
            }
        }
        pair.sort(Integer::compareTo);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=pair.get(i);
        }
        return sum;
    }
}
