/**
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 

 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 

 
 
 

 示例 1： 

 
输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 

 示例 2： 

 
输入：nums = [0]
输出：[[],[0]]
 

 

 提示： 

 
 1 <= nums.length <= 10 
 -10 <= nums[i] <= 10 
 
 
 
 Related Topics 位运算 数组 回溯 👍 774 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new LinkedList();
    Deque<Integer> path = new LinkedList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        result.add(new LinkedList(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
