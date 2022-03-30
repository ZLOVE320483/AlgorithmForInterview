package com.zlove.practice;

import java.util.*;

public class Main {

    List<List<Integer>> res = new LinkedList();
    Deque<Integer> path = new LinkedList();

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
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
