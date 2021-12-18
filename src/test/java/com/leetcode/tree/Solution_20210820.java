package com.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层序遍历
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/
 *
 * @author: chenyutao
 * @date: 2021/8/20 3:58 下午
 */
public class Solution_20210820 {


    @Test
    public void test() {

    }

    /**
     * down
     * 执行用时：1 ms, 在所有 Java 提交中击败了 92.96% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了 10.00% 的用户
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue1.add(root);
        while (!queue1.isEmpty()) {
            List<Integer> levelValues = new LinkedList<>();
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                levelValues.add(node.val);
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }
            if(!levelValues.isEmpty()){
                result.add(levelValues);
            }
            queue1 = queue2;
            queue2 =new LinkedList<>();
        }
        return result;
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
