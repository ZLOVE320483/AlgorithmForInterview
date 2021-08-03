package com.zlove.practice.tree;

/**
 * 判断二叉树是否为平衡二叉树
 */
public class IsBalanced {

    /**
     * 前序遍历，从顶层向下遍历
     * @param root 根节点
     * @return 是否是平衡二叉树
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        return Math.max(left, right) + 1;
    }

    /**
     * 后序遍历，从底层向上
     * @param root 根节点
     * @return 是否是平衡二叉树
     */
    public static boolean isBalanced2(TreeNode root) {
        return treeHeight2(root) != -1;
    }

    private static int treeHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeHeight2(root.left);
        int right = treeHeight2(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
