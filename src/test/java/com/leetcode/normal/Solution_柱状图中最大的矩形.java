package com.leetcode.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author: chenyutao
 * @date: 2022/1/5 9:58 下午
 */
public class Solution_柱状图中最大的矩形 {
    /**
     * 参考答案： 单调栈
     * todo未完成
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> noResultStack = new Stack<>();
        List<Integer> resultList = new ArrayList<>(heights.length);
        for (int index = 0; index < heights.length; index++) {
            if(noResultStack.isEmpty()){
                noResultStack.push(index);
            }else {
                Integer topIndex = noResultStack.peek();
                if(heights[index]>=heights[topIndex]){
                    noResultStack.push(index);
                }else {
                    noResultStack.pop();
                    Integer leftIndex = noResultStack.peek();
                    int rightIndex = index;
                    int height = heights[topIndex];
                    int result = height*(rightIndex-leftIndex);
                    resultList.add(topIndex,result);
                }
            }
        }
        return 0;
    }
}
