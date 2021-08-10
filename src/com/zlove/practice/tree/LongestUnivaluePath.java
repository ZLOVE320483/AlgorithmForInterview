package com.zlove.practice.tree;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * https://leetcode-cn.com/problems/longest-univalue-path/
 *
 */
public class LongestUnivaluePath {

    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        arrowLength(root);
        return ans;
    }

    private int arrowLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = arrowLength(root.left);
        int right = arrowLength(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight = right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
