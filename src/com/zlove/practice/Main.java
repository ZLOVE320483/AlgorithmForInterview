package com.zlove.practice;


import com.zlove.practice.tree.KthLargest;
import com.zlove.practice.tree.TreeNode;
import com.zlove.practice.utils.PrintUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        PrintUtils.printList(twoSum(nums, 6));
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int value = map.get(target - nums[i]);
            if (map.containsKey(target - nums[i]) && value != i) {
                return new int[] {i, value};
            }
        }
        return new int[2];
    }
}
