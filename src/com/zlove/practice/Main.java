package com.zlove.practice;


import com.zlove.practice.tree.FindBottomLeftValue;
import com.zlove.practice.tree.TreeNode;
import com.zlove.practice.utils.PrintUtils;

import java.util.*;

public class Main {

    Map<Integer, TreeNode> parent = new HashMap();
    Set<Integer> visited = new HashSet();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node3.right = node4;
        FindBottomLeftValue value = new FindBottomLeftValue();
        System.out.println(value.findBottomLeftValue1(root));
    }


    private TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
