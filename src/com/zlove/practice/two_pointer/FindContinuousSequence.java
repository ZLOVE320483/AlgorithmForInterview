package com.zlove.practice.two_pointer;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> res = new LinkedList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;
        while (end < target) {
            if (curSum < target) {
                end++;
                curSum+=end;
            } else if (curSum > target) {
                curSum-=start;
                start++;
            } else {
                List<Integer> tmp = new LinkedList<>();
                for (int i = start; i <= end; i++) {
                    tmp.add(i);
                }
                res.add(tmp);
                curSum-=start;
                start++;
                end++;
                curSum+=end;
            }
        }
        int[][] ret = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int[] item = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                item[j] = res.get(i).get(j);
            }
            ret[i] = item;
        }
        return ret;
    }
}
