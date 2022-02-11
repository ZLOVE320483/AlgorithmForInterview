/**
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 

 

 示例 1： 

 
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
 

 示例 2： 

 
输入：root = [1]
输出：[[1]]
 

 示例 3： 

 
输入：root = []
输出：[]
 

 

 提示： 

 
 树中节点数目在范围 [0, 2000] 内 
 -1000 <= Node.val <= 1000 
 
 Related Topics 树 广度优先搜索 二叉树 👍 1170 👎 0

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                level.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
