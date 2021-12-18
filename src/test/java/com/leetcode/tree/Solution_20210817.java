package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
 *
 * @author: chenyutao
 * @date: 2021/8/17 6:50 下午
 */
public class Solution_20210817 {

    private TreeNode exampleTree;


    /**
     * down
     * 不太好，修改了数据
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        TreeNode currNode = root;
        int maxDepth = 1;
        List<TreeNode> path = new ArrayList<>();
        path.add(root);

        while (true) {
            if (currNode.left != null) {
                path.add(currNode.left);
                currNode = currNode.left;
                if (path.size() > maxDepth) {
                    maxDepth = path.size();
                }
            } else if (currNode.right != null) {
                path.add(currNode.right);
                currNode = currNode.right;
                if (path.size() > maxDepth) {
                    maxDepth = path.size();
                }
            } else {
                path.remove(path.size() - 1);
                if (path.size() == 0) {
                    break;
                }
                TreeNode parent = path.get(path.size() - 1);
                if (currNode == parent.left) {
                    parent.left = null;
                } else if (currNode == parent.right) {
                    parent.right = null;
                }
                currNode = parent;
            }
        }
        return maxDepth;
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

