package com.zlove.practice.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {
    int postIndex;
    int[] inOrder;
    int[] postOrder;
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    private TreeNode helper(int leftInOder, int rightInOrder) {
        if (leftInOder > rightInOrder) {
            return null;
        }
        int rootVal = postOrder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = inOrderIndexMap.get(rootVal);
        postIndex--;
        root.right = helper(index + 1, rightInOrder);
        root.left = helper(leftInOder, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        postIndex = postorder.length - 1;
        int index = 0;
        for (Integer val : inorder) {
            inOrderIndexMap.put(val, index++);
        }
        return helper(0, inorder.length - 1);
    }
}
