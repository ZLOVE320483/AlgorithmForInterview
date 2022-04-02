package com.zlove.practice;

import com.zlove.practice.utils.PrintUtils;

import java.util.*;

public class Main {

    List<List<Integer>> res = new LinkedList();
    Deque<Integer> path = new LinkedList();

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        PrintUtils.printList(nums);
    }

    public static void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int left = 0, right = nums.length - 1;
        int tmp;
        for (int i = 0; i < right;) {
            if (nums[i] == 0) {
                tmp = nums[left];
                nums[left] = nums[i];
                left++;
                nums[i] = tmp;
            } else if (nums[i] == 2) {
                tmp = nums[right];
                nums[right] = nums[i];
                right--;
                nums[i] = tmp;
            } else {
                i++;
            }
        }
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (sum == target) {
                result = Math.min(result, right - left + 1);
            }
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
        }
        return result;
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, 0, 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new LinkedList(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.addLast(candidates[i]);
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
