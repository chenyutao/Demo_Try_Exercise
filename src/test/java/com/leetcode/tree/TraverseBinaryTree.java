package com.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: chenyutao
 * @date: 2021/8/18 11:29 上午
 */
public class TraverseBinaryTree {
    /**
     * 前序遍历 递归
     * 中序/后序 差不多
     */
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    // 前序遍历 非递归
    public void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.val + "->");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }
        }
    }

    // 中序遍历 非递归
    public void inOrderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                System.out.print(tem.val + "->");
                node = tem.right;
            }
        }
    }


    // 后序遍历 非递归
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
        }
    }

    // 层序遍历
    public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "->");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    private void visit(TreeNode treeNode) {
        System.out.println(treeNode.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void test() {

        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);
        TreeNode node7 = new TreeNode(1, node1, node2);
        TreeNode node8 = new TreeNode(5, node3, node4);
        TreeNode root = new TreeNode(3, node7, node8);

        postorderTraversal(root);

    }
}
