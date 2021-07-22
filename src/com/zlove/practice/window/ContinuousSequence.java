package com.zlove.practice.window;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContinuousSequence {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> resList = new ArrayList<>();
        int start = 1;
        int end = 1;
        int sum = 0;
        while (start <= target / 2) {
            if (sum < target) {
                sum += end;
                end++;
            } else if (sum > target) {
                sum -= start;
                start++;
            } else {
                int[] tmp = new int[end - start];
                for (int k = start; k < end; k++) {
                    tmp[k - start] = k;
                }
                resList.add(tmp);
                sum -= start;
                start++;
            }
        }

        int[][] res = new int[resList.size()][];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
