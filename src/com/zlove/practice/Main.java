package com.zlove.practice;

import java.util.*;

public class Main {

    List<List<Integer>> res = new LinkedList();
    Deque<Integer> path = new LinkedList();

    public static void main(String[] args) {
        String a = "a" + "b";
        String b = "ab";
        System.out.println(a == b);
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
