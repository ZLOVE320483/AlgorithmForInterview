package com.zlove.practice;

import com.zlove.practice.utils.PrintUtils;
import com.zlove.practice.window.ContinuousSequence;

public class Main {

    public static void main(String[] args) {
        int[][] res = ContinuousSequence.findContinuousSequence(15);
        for (int i = 0; i < res.length; i++) {
            PrintUtils.printList(res[i]);
        }
    }
}
