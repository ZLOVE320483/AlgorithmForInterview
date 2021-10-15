package com.zlove.practice.array;

import java.util.Map;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0, max = 0;
        for (int num : nums) {
            if (num == 0) {
                cur = 0;
            } else {
                cur++;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
