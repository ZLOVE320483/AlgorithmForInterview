package com.zlove.practice.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一颗二叉查找树，返回树中是否存在两个节点，和为定值
 */
public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> res = new LinkedList<>();
        inOrderTrans(root, res);
        int i = 0, j = res.size() - 1;
        while (i < j) {
            int sum = res.get(i) + res.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
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
