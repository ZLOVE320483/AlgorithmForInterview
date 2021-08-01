package com.zlove.practice.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 求二叉树的最小深度
 */
public class MinDepth {

    /**
     * 递归实现
     * @param root 二叉树根节点
     * @return 二叉树最小深度
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m = minDepth(root.left);
        int n = minDepth(root.right);
        if (m == 0 || n == 0)
            return m + n + 1;
        return Math.min(m, n) + 1;
    }

    /**
     * 非递归实现
     * @param root 二叉树根节点
     * @return 二叉树最小深度
     */
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = deque.poll();
                if (curNode.left == null && curNode.right == null) {
                    return depth;
                }
                if (curNode.left != null) {
                    deque.offer(curNode.left);
                }
                if (curNode.right != null) {
                    deque.offer(curNode.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
