/**
给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。 

 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。 

 

 
 

 示例 1： 

 

 
输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
输出：[7,4,1]
解释：所求结点为与目标结点（值为 5）距离为 2 的结点，值分别为 7，4，以及 1
 

 示例 2: 

 
输入: root = [1], target = 1, k = 3
输出: []
 

 

 提示: 

 
 节点数在 [1, 500] 范围内 
 0 <= Node.val <= 500 
 Node.val 中所有值 不同 
 目标结点 target 是树上的结点。 
 0 <= k <= 1000 
 

 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 508 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, TreeNode> parents = new HashMap();
    private List<Integer> ans = new LinkedList();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        findAns(target, null, 0, k);
        return ans;
    }

    private void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    private void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
