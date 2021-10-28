package com.zlove.practice.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : arr) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int size = queue.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
