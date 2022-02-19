package com.zlove.practice;


import com.zlove.practice.tree.TreeNode;
import com.zlove.practice.utils.PrintUtils;

import java.util.*;

public class Main {

    Map<Integer, TreeNode> parent = new HashMap();
    Set<Integer> visited = new HashSet();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);

        root.left = left;
        root.right = right;

        Main main = new Main();
        System.out.println(main.solution1(root, left, right));
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
