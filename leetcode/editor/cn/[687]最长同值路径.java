/**
给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 

 两个节点之间的路径长度 由它们之间的边数表示。 

 

 示例 1: 

 

 
输入：root = [5,4,5,1,1,5]
输出：2
 

 示例 2: 

 

 
输入：root = [1,4,5,4,4,5]
输出：2
 

 

 提示: 

 
 树的节点数的范围是 [0, 10⁴] 
 -1000 <= Node.val <= 1000 
 树的深度将不超过 1000 
 
 Related Topics 树 深度优先搜索 二叉树 👍 538 👎 0

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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = 0, rightPath = 0;
        if (root.left != null && root.val == root.left.val) {
            leftPath = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightPath = right + 1;
        }
        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
