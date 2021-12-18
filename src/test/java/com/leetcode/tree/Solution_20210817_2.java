package com.leetcode.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 *
 * @author: chenyutao
 * @date: 2021/8/17 7:27 下午
 */
public class Solution_20210817_2 {
//
//
//    TreeNode node1 = new TreeNode(0);
//    TreeNode node2 = new TreeNode(2);
//    TreeNode node3 = new TreeNode(4);
//    TreeNode node4 = new TreeNode(6);
//    TreeNode node7 = new TreeNode(1,node1,node2);
//    TreeNode node8 = new TreeNode(5,node3,node4);
//    TreeNode root = new TreeNode(3,node7,node8);

    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(7);
    TreeNode node3 = new TreeNode(6,node1,node2);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5,node4,node3);



    @Test
    public void test() {
        boolean validBST = isValidBST(node5);
        System.out.println(validBST);
    }


    Map<TreeNode,Integer> maxChildValMap = new HashMap<>();
    Map<TreeNode,Integer> minChildValMap= new HashMap<>();
    boolean isValidBST = true;

    public boolean isValidBST(TreeNode root) {
        postorderTraversal(root);
        return isValidBST;
    }


    public void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur = null;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            visit(node);
            if(!isValidBST){
                return;
            }
        }
    }

    /**
     * down
     * 耗时很久
     */
    private void visit(TreeNode node) {
        if(node.left!=null ){
            if(node.val<=node.left.val || node.val<=maxChildValMap.get(node.left)){
                isValidBST =  false;
            }else {
                minChildValMap.put(node,minChildValMap.get(node.left));
            }
        }else {
            minChildValMap.put(node,node.val);
        }
        if(node.right!=null ){
            if(node.val>=node.right.val || node.val>=minChildValMap.get(node.right)){
                isValidBST =  false;
            }else {
                maxChildValMap.put(node,maxChildValMap.get(node.right));
            }
        }else {
            maxChildValMap.put(node,node.val);
        }




    }



    /**
     * official Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

