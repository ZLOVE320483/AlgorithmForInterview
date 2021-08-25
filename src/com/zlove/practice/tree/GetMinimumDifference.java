package com.zlove.practice.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class GetMinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inOrderTrans(root, res);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            min = Math.min(min, res.get(i) - res.get(i - 1));
        }
        return min;
    }

    private void inOrderTrans(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTrans(root.left, list);
        list.add(root.val);
        inOrderTrans(root.right, list);
    }
}
