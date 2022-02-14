/**
给定一个二叉树，找出其最小深度。 

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 

 说明：叶子节点是指没有子节点的节点。 

 

 示例 1： 

 
输入：root = [3,9,20,null,null,15,7]
输出：2
 

 示例 2： 

 
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
 

 

 提示： 

 
 树中节点数的范围在 [0, 10⁵] 内 
 -1000 <= Node.val <= 1000 
 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 670 👎 0

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
    public int minDepth(TreeNode root) {
        return minDepth2(root);
    }

    private int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

    private int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Deque<TreeNode> deque = new LinkedList();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
