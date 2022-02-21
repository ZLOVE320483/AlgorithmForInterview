/**
给定二叉树的根节点 root ，返回所有左叶子之和。 

 

 示例 1： 

 

 
输入: root = [3,9,20,null,null,15,7] 
输出: 24 
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 

 示例 2: 

 
输入: root = [1]
输出: 0
 

 

 提示: 

 
 节点数在 [1, 1000] 范围内 
 -1000 <= Node.val <= 1000 
 

 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 400 👎 0

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
    public int sumOfLeftLeaves(TreeNode root) {
        return solution2(root);
    }

    private int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Deque<TreeNode> deque = new LinkedList();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.left != null) {
                if (isLeaf(node.left)) {
                    sum += node.left.val;
                } else {
                    deque.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeaf(node.right)) {
                    deque.offer(node.right);
                }
            }
        }
        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
