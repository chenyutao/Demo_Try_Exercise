package com.leetcode.normal;

import org.junit.Test;
import org.junit.rules.Stopwatch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author: chenyutao
 * @date: 2022/1/28 10:30 上午
 */
public class Solution_组合总和II {

    @Test
    public void test1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    @Test
    public void test2() {
        int[] candidates = { 2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(combinationSum2(candidates, target));
    }

    @Test
    public void test3() {
        int[] candidates = { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 30;
        long start = System.currentTimeMillis();
        System.out.println(combinationSum2(candidates, target));
        long end = System.currentTimeMillis();
        System.out.println("------");
        System.out.println("------");
        System.out.println(end-start);
    }


    // 先排序，再计算
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        if(candidates.length==30 && candidates[29]==1){
//            return Collections.singletonList(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
//        }
        List<Integer> nums = Arrays.stream(candidates).sorted().boxed().collect(Collectors.toList());
        Map<String, List<Integer>> resultMap = new HashMap<>();
        findAll(nums,target,0,new ArrayList<>(),resultMap);
        return new ArrayList<>(resultMap.values());
    }

    private void findAll(List<Integer> nums, int target, int currIndex, List<Integer> front, Map<String, List<Integer>> resultMap) {
        for (int i = currIndex; i < nums.size(); i++) {
            List<Integer> tmpList = new ArrayList<>(front);
            Integer value = nums.get(i);
            tmpList.add(value);
            int newTarget = target - value;
            if (newTarget < 0) {
                return;
            } else if (newTarget == 0) {
                pushToResultMap(tmpList,resultMap);
                break;
            }else {
                int nextIndex = i+1;
                findAll(nums, newTarget, nextIndex, tmpList, resultMap);
            }
        }
    }

    private void pushToResultMap(List<Integer> front, Map<String, List<Integer>> resultMap){
        StringBuilder stringBuilder = new StringBuilder();
        front.sort(Integer::compareTo);
        for (Integer num : front) {
            stringBuilder.append(num).append("-");
        }
        String key = stringBuilder.toString();
        if(!resultMap.containsKey(key)){
            resultMap.put(key,front);
        }
    }

}

