package com.interview.microsoft;

import java.util.*;

/**
 * @author: chenyutao
 * @date: 2022/1/26 1:39 下午
 */
public class Tmp3 {
    // 若干数字，有正数有负数，总和最大的组合
    // 相邻数字不可以都被选中

    public int maxCombine(int[] nums){
        return 0;
    }

    public void allNature(int[] nums){
        // 无排序的正数
         List<Integer> natures = new ArrayList<>();
         Set<Integer> noRepeatSet = new HashSet<>();
         // k: natureList序号， v: 原始数组序号
         Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                natures.add(nums[i]);
                indexMap.put(natures.size(),i);
            }
        }

        // 找最大组合
        while(true){

        }


    }

}
