package com.zlove.practice.two_pointer;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        if (isSqrt(c)) {
            return true;
        }
        for (int i = 0; i <= Math.sqrt(c); i++) {
            if (isSqrt(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSqrt(int num) {
        int c = (int) Math.sqrt(num);
        if (c * c == num) {
            return true;
        }
        return false;
    }
}
