/**
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 

 叶子节点 是指没有子节点的节点。 
 

 示例 1： 

 
输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
 

 示例 2： 

 
输入：root = [1]
输出：["1"]
 

 

 提示： 

 
 树中节点的数目在范围 [1, 100] 内 
 -100 <= Node.val <= 100 
 
 Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 650 👎 0

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
    public List<String> binaryTreePaths(TreeNode root) {
        return solution2(root);
    }

    private List<String> solution1(TreeNode root) {
        List<String> res = new LinkedList();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            paths.add(stringBuilder.toString());
        } else {
            stringBuilder.append("->");
            dfs(root.left, stringBuilder.toString(), paths);
            dfs(root.right, stringBuilder.toString(), paths);
        }

    }

    private List<String> solution2(TreeNode root) {
        List<String> res = new LinkedList();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> nodes = new LinkedList();
        Deque<String> paths = new LinkedList();
        nodes.offer(root);
        paths.offer(String.valueOf(root.val));
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            String path = paths.poll();
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.left != null) {
                nodes.offer(node.left);
                paths.offer(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                paths.offer(path + "->" + node.right.val);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
