/**
给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 

 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 

 

 示例 1： 

 

 
输入: root = [5,2,-3]
输出: [2,-3,4]
 

 示例 2： 

 

 
输入: root = [5,2,-5]
输出: [2]
 

 

 提示: 

 
 节点数在 [1, 10⁴] 范围内 
 -10⁵ <= Node.val <= 10⁵ 
 
 Related Topics 树 深度优先搜索 哈希表 二叉树 👍 139 👎 0

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
    private int max = 0;
    private Map<Integer, Integer> countMap = new HashMap();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        treeSum(root);
        List<Integer> list = new LinkedList();
        for (Integer i : countMap.keySet()) {
            if (countMap.get(i) == max) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeSum(root.left);
        int right = treeSum(root.right);
        int val = root.val + left + right;
        countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        max = Math.max(max, countMap.get(val));
        return val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
