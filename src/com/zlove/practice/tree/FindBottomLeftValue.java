package com.zlove.practice.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
    给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

    假设二叉树中至少有一个节点。
 */
public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            root = deque.poll();
            if (root.right != null) {
                deque.offer(root.right);
            }
            if (root.left != null) {
                deque.offer(root.left);
            }
        }
        return root.val;
    }

    int max = Integer.MIN_VALUE;
    int res;
    public int findBottomLeftValue1(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int depth){
        if(node != null){
            if(node.left == null && node.right == null){
                if(max < depth){
                    max = depth;
                    res = node.val;
                }
            }
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }
}
