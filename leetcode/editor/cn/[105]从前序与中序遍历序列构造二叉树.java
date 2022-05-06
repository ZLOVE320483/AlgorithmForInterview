/**
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回
其根节点。 

 

 示例 1: 

 
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
 

 示例 2: 

 
输入: preorder = [-1], inorder = [-1]
输出: [-1]
 

 

 提示: 

 
 1 <= preorder.length <= 3000 
 inorder.length == preorder.length 
 -3000 <= preorder[i], inorder[i] <= 3000 
 preorder 和 inorder 均 无重复 元素 
 inorder 均出现在 preorder 
 preorder 保证 为二叉树的前序遍历序列 
 inorder 保证 为二叉树的中序遍历序列 
 
 Related Topics 树 数组 哈希表 分治 二叉树 👍 1415 👎 0

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

    private int[] preOrder;
    private int[] inOrder;
    private Map<Integer, Integer> inOrderIndexMap = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return helper(0, length - 1, 0, length - 1);
    }

    private TreeNode helper(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootVal = preOrder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootInOrdexIndex = inOrderIndexMap.get(rootVal);
        int size = rootInOrdexIndex - inLeft;
        root.left = helper(preLeft + 1, preLeft + size, inLeft, rootInOrdexIndex - 1);
        root.right = helper(preLeft + size + 1, preRight, rootInOrdexIndex + 1, inRight);
        return root;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
