package com.zlove.practice.tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterOfBinaryTree {

    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
