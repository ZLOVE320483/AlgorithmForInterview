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
        return solution2(root.left, root.right);
    }

    private boolean solution1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return solution1(p.left, q.right) && solution1(p.right, q.left);
    }

    private boolean solution2(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList();
        deque.offer(p);
        deque.offer(q);
        while (!deque.isEmpty()) {
            TreeNode node1 = deque.poll();
            TreeNode node2 = deque.poll();

            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            deque.offer(node1.left);
            deque.offer(node2.right);
            deque.offer(node1.right);
            deque.offer(node2.left);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
