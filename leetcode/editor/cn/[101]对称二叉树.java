/**
给你一个二叉树的根节点 root ， 检查它是否轴对称。 

 

 示例 1： 

 
输入：root = [1,2,2,3,4,4,3]
输出：true
 

 示例 2： 

 
输入：root = [1,2,2,null,3,null,3]
输出：false
 

 

 提示： 

 
 树中节点数目在范围 [1, 1000] 内 
 -100 <= Node.val <= 100 
 

 

 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1730 👎 0

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric2(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    private boolean isSymmetric2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
