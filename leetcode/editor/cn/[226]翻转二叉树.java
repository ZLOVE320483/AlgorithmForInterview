/**
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 

 

 示例 1： 

 

 
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
 

 示例 2： 

 

 
输入：root = [2,1,3]
输出：[2,3,1]
 

 示例 3： 

 
输入：root = []
输出：[]
 

 

 提示： 

 
 树中节点数目范围在 [0, 100] 内 
 -100 <= Node.val <= 100 
 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1174 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode invertTree(TreeNode root) {
        return solution3(root);
    }

    private TreeNode solution1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private TreeNode solution2(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        solution2(root.left);
        solution2(root.right);
        return root;
    }

    private TreeNode solution3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }

    private void swap(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
