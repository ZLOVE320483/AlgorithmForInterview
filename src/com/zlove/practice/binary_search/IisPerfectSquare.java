package com.zlove.practice.binary_search;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IisPerfectSquare {

    public static void main(String[] args) {
        IisPerfectSquare perfectSquare = new IisPerfectSquare();
        System.out.println(perfectSquare.isPerfectSquare(808201));
    }

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2;
        long mid;
        long guess;
        while (left <= right) {
            mid = left + (right - left) / 2;
            guess = mid * mid;
            if (guess == num) {
                System.out.println(mid);
                return true;
            }
            if (guess > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
