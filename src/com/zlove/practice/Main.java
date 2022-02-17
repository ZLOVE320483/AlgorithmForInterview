package com.zlove.practice;


import com.zlove.practice.tree.TreeNode;
import com.zlove.practice.utils.PrintUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.right = node5;
        node3.right = node4;

        List<Integer> res = rightSideView(root);
        PrintUtils.printList(res);
    }


    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList();
        stack.offer(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
            }
        }
        return res;
    }
}
