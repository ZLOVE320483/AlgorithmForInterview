package com.zlove.practice.backtrack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab 和cba。
 */
public class BackTrackPermute {

    private static List<String> res = new LinkedList<>();
    public static List<String> permute(String target) {
        char[] charArr = target.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        backtrace(deque, charArr);
        return res;
    }

    private static void backtrace(Deque<Character> deque, char[] charArr) {
        if (deque.size() == charArr.length) {
            StringBuilder builder = new StringBuilder();
            for (char c : deque) {
                builder.append(c);
            }
            res.add(builder.toString());
        }
        for (char c : charArr) {
            if (deque.contains(c)) {
                continue;
            }
            deque.add(c);
            backtrace(deque, charArr);
            deque.removeLast();
        }
    }

}
