/**
给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。 

 返回移除了所有不包含 1 的子树的原二叉树。 

 节点 node 的子树为 node 本身加上所有 node 的后代。 

 

 示例 1： 

 
输入：root = [1,null,0,0,1]
输出：[1,null,0,null,1]
解释：
只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 

 示例 2： 

 
输入：root = [1,0,1,0,0,0,1]
输出：[1,null,1,null,1]
 

 示例 3： 

 
输入：root = [1,1,0,1,1,0,1,0]
输出：[1,1,0,1,1,null,1]
 

 

 提示： 

 
 树中节点的数目在范围 [1, 200] 内 
 Node.val 为 0 或 1 
 
 Related Topics 树 深度优先搜索 二叉树 👍 212 👎 0

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
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean leftHas = containsOne(node.left);
        boolean rightHas = containsOne(node.right);
        if (!leftHas) node.left = null;
        if (!rightHas) node.right = null;
        return node.val == 1 || leftHas || rightHas;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
