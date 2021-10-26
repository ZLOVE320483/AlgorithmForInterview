package com.zlove.practice.window;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k < 1) {
            return nums;
        }
        List<Integer> tmpList = new LinkedList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        tmpList.add(queue.peek());
        for (int i = 0, j = k; j < nums.length; i++, j++) {
            queue.remove(nums[i]);
            queue.offer(nums[j]);
            tmpList.add(queue.peek());
        }
        int[] res = new int[tmpList.size()];
        for (int i = 0; i < tmpList.size(); i++) {
            res[i] = tmpList.get(i);
        }
        return res;
    }
}
