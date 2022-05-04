/**
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 

 叶子节点 是指没有子节点的节点。 

 
 
 

 示例 1： 

 
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
 

 示例 2： 

 
输入：root = [1,2,3], targetSum = 5
输出：[]
 

 示例 3： 

 
输入：root = [1,2], targetSum = 0
输出：[]
 

 

 提示： 

 
 树中节点总数在范围 [0, 5000] 内 
 -1000 <= Node.val <= 1000 
 -1000 <= targetSum <= 1000 
 
 
 
 Related Topics 树 深度优先搜索 回溯 二叉树 👍 668 👎 0

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

    List<List<Integer>> res = new LinkedList();
    Deque<Integer> path = new LinkedList();
    Map<TreeNode, TreeNode> map = new HashMap();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        bfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }

    private void bfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> nodes = new LinkedList();
        Deque<Integer> vals = new LinkedList();
        nodes.offer(root);
        vals.offer(root.val);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int val = vals.poll();
            if (node.left == null
                    && node.right == null
                    && val == targetSum) {
                getPath(node);
            }
            if (node.left != null) {
                map.put(node.left, node);
                nodes.offer(node.left);
                vals.offer(val + node.left.val);
            }
            if (node.right != null) {
                map.put(node.right, node);
                nodes.offer(node.right);
                vals.offer(val + node.right.val);
            }
        }
    }

    private void getPath(TreeNode node) {
        List<Integer> tmp = new LinkedList();
        while (node != null) {
            tmp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(tmp);
        res.add(tmp);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
