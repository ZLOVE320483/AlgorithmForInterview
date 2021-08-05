package com.zlove.practice.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasPathSum {

    /**
     *  非递归算法
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        Deque<Integer> valDeque = new LinkedList<>();
        nodeDeque.offer(root);
        valDeque.offer(root.val);
        while (!nodeDeque.isEmpty()) {
            TreeNode curNode = nodeDeque.poll();
            Integer curVal = valDeque.poll();
            if (curNode.left == null && curNode.right == null
                    && curVal != null && curVal == targetSum) {
                return true;
            }
            if (curNode.left != null) {
                nodeDeque.offer(curNode.left);
                valDeque.offer(curVal + curNode.left.val);
            }
            if (curNode.right != null) {
                nodeDeque.offer(curNode.right);
                valDeque.offer(curVal + curNode.right.val);
            }
        }
        return false;
    }

    /**
     * 递归算法
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum2(root.left, targetSum - root.val)
                || hasPathSum2(root.right, targetSum - root.val);
    }
}
