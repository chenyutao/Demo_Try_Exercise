package com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chenyutao
 * @date: 2022/2/11 10:26 上午
 */
public class Tmp {
    @Test
    public void test() {
        int[] golds = new int[]{1,-4,1,6};
        // -5,-6,-7,-2,-4,100
        System.out.println(tryMax2(golds));
    }

    /**
     * 每次 1/2/3 阶
     * 金币数有正负
     */
    public int tryMax2(int[] golds){
        cache.put(0,0);
        return tmpTry(golds,golds.length-1,3);
    }

    Map<Integer,Integer> cache = new HashMap<>();
    public int tmpTry(int[] golds,int endIndex,int maxStep){
        if(cache.containsKey(endIndex)){
            return cache.get(endIndex);
        }
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= maxStep; i++) {
            int tmpIndex = endIndex - i;
            if(tmpIndex <0){
                break;
            }
            int value = tmpTry(golds, tmpIndex,maxStep)+golds[tmpIndex];
            cache.put(tmpIndex,value);
            values.add(value);
        }
        return values.stream().max(Integer::compareTo).get();
    }

//
//    /**
//     * 每次 1/2/3 阶
//     * 金币数有正负
//     */
//    public int tryMax(int[] golds){
//        int index = golds.length-1;
//        int max = 0;
//        while (index>=0){
//            int step = 3;
//            for (int i = 0; i < step ; i++) {
//                index--;
//                int gold = golds[index];
//                if(gold>0){
//                    max+=gold;
//                    break;
//                }
//            }
//            int next = calIndex(index, step, golds);
//            max+=golds[next];
//            index = next;
//        }
//        return max;
//    }
//
//
//    public int calIndex(int startIndex,int step,int[] golds){
//        Map<Integer,Integer> map = new HashMap<>();
//        int index = startIndex+step;
//        for (int i = 0; i < step; i++) {
//            int tmpIndex = index-i;
//            int tmpValue = golds[tmpIndex];
//            map.put(tmpValue,tmpIndex);
//        }
//        Integer maxValue = map.keySet().stream().max(Integer::compareTo).get();
//        return map.get(maxValue);
//    }

    // 方案1：每个走法 计算一遍
    // 方案2：从数字上推导走法

    // 贪心算法3：

}
