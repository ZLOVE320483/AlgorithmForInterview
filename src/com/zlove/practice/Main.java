package com.zlove.practice;


import com.zlove.practice.tree.FindBottomLeftValue;
import com.zlove.practice.tree.TreeNode;
import com.zlove.practice.utils.PrintUtils;

import java.util.*;

public class Main {

    Map<Integer, TreeNode> parent = new HashMap();
    Set<Integer> visited = new HashSet();

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1111");
        set.add("2222");
        System.out.println(Arrays.toString(set.toArray()));
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
