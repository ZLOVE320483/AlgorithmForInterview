package com.zlove.practice.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 后序序 遍历。
 */
public class PostOrderTraversal {

    /**
     * 递归方式
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    /**
     * 非递归方式
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                if (node.right == null || node.right == pre) {
                    res.add(node.val);
                    pre = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }

        return res;
    }
}
