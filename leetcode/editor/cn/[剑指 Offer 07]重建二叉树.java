/**
输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 

 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 

 

 示例 1: 

 
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
 

 示例 2: 

 
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

 

 限制： 

 0 <= 节点个数 <= 5000 

 

 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
preorder-and-inorder-traversal/ 
 Related Topics 树 数组 哈希表 分治 二叉树 👍 714 👎 0

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

    Map<Integer, Integer> inOrderIndexMap = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                    int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int preRoot = preorder[preLeft];
        int rootIndex = inOrderIndexMap.get(preRoot);
        int subLeftSize = rootIndex - inLeft;
        TreeNode root = new TreeNode(preRoot);
        root.left = buildTreeHelper(preorder, inorder,
                preLeft + 1, preLeft + subLeftSize, inLeft, rootIndex - 1);
        root.right = buildTreeHelper(preorder, inorder,
                preLeft + subLeftSize + 1, preRight, rootIndex + 1, inRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
