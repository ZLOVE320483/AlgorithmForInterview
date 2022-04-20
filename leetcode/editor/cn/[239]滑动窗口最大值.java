/**
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 


 返回 滑动窗口中的最大值 。 

 

 示例 1： 

 
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

 示例 2： 

 
输入：nums = [1], k = 1
输出：[1]
 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 1 <= k <= nums.length 
 
 Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1565 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class MyQueue {
        Deque<Integer> deque;

        MyQueue() {
            deque = new LinkedList();
        }

        void poll(int val) {
            if (!deque.isEmpty() && deque.peek() == val) {
                deque.poll();
            }
        }

        void add(int val) {
            while (!deque.isEmpty() && deque.peekLast() < val) {
                deque.pollLast();
            }
            deque.offerLast(val);
        }

        int peek() {
            return deque.peek();
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        int length = nums.length;
        int[] res = new int[length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[index++] = queue.peek();
        for (int i = k; i < length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            res[index++] = queue.peek();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
