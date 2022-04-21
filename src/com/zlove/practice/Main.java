package com.zlove.practice;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
    }


    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList();
        char[] cs = s.toCharArray();
        stack.push(cs[0]);
        for (int i = 1; i < cs.length; i++) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (cs[i] == top) {
                    stack.pop();
                } else {
                    stack.push(cs[i]);
                }
            } else {
                stack.push(cs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> deque = new LinkedList();
        for (int i = 0; i < names.length; i++) {
            if ("..".equals(names[i])) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (names[i].length() > 0 && !".".equals(names[i])) {
                deque.offerLast(names[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        if (deque.isEmpty()) {
            builder.append("/");
        } else {
            while (!deque.isEmpty()) {
                builder.append("/");
                builder.append(deque.poll());
            }
        }
        return builder.toString();
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length - 1; i++) {
            if (!splits[i].isEmpty()) {
                sb.append(splits[i]);
                sb.append(" ");
            } else {
                if (sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(" ");
                }
            }
        }
        sb.append(splits[splits.length - 1]);
        String source = sb.toString();
        String[] resSplits = source.split(" ");
        reverse(resSplits);
        StringBuilder resSb = new StringBuilder();
        for (int i = 0; i < resSplits.length - 1; i++) {
            resSb.append(resSplits[i]);
            resSb.append(" ");
        }
        resSb.append(resSplits[resSplits.length - 1]);
        return resSb.toString();
    }

    private void reverse(String[] source) {
        int start = 0, end = source.length - 1;
        while (start < end) {
            String tmp = source[start];
            source[start] = source[end];
            source[end] = tmp;
            start++;
            end--;
        }
    }
}
