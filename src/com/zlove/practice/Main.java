package com.zlove.practice;


import com.zlove.practice.tree.KthLargest;
import com.zlove.practice.tree.TreeNode;
import com.zlove.practice.utils.PrintUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);

        node1.right = node2;
        root.left = node1;
        root.right = node4;

        List<Integer> res = new KthLargest().inOrderTrans(root);
        PrintUtils.printList(res);
    }
}
