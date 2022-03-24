/**
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 

 

 示例 1： 

 
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 

 示例 2： 

 
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 

 提示： 

 
 1 <= nums.length <= 8 
 -10 <= nums[i] <= 10 
 
 Related Topics 数组 回溯 👍 982 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new LinkedList();
    Deque<Integer> path = new LinkedList();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums);
        return result;
    }

    private void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new LinkedList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                backTracking(nums);
                used[i] = false;
                path.removeLast();
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
