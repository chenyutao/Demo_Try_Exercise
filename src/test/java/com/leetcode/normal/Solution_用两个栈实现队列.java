package com.leetcode.normal;

import java.util.Stack;


public class Solution_用两个栈实现队列 {

    /**
     * 基础方案： 第一个栈用来存数据，要取队首的时候，全部数据迁移到第二个栈；、
     * 优化思考： 实际上迁移到第二个栈以后，不需要把数据迁移回来。第一个栈继续用来做入队；出队时使用第二个栈的栈顶即可
     */
    class CQueue{
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int status = 1;

        public CQueue() {
        }

        public void appendTail(int value) {
            if(status==1){
                stack1.add(value);
            } else {
                tranData(stack2,stack1);
                stack1.add(value);
                status=1;
            }
        }

        public int deleteHead() {
            if(stack1.isEmpty() && stack2.isEmpty()){
                return -1;
            }
            if(status==0){
                return stack2.pop();
            } else {
                tranData(stack1,stack2);
                Integer val = stack2.pop();
                status=0;
                return val;
            }
        }

        public void tranData(Stack<Integer> stack1,Stack<Integer> stack2){
            while (!stack1.isEmpty()){
                Integer val = stack1.pop();
                stack2.add(val);
            }
        }


        public void appendTail2(int value) {
            stack1.push(value);
        }

        public int deleteHead2() {
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.isEmpty() ? -1 : stack2.pop();
            }
        }
    }

}
