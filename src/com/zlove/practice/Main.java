package com.zlove.practice;

import com.zlove.practice.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] g = {10, 9, 8, 7};
        int[] s= {5, 6, 7, 8};
        System.out.println(main.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int countOfChildren = g.length;
        int countOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < countOfChildren && j < countOfCookies; i++, j++) {
            while (j < countOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < countOfCookies) {
                count++;
            }
        }
        return count;
    }

    public String decodeString(String s) {
        char[] chArr = s.toCharArray();
        Deque<Character> stack = new LinkedList();
        for (int i = 0; i < chArr.length; i++) {
            char curCh = chArr[i];
            if (curCh != ']') {
                stack.push(curCh);
            } else {
                StringBuilder builder = new StringBuilder();
                char top = stack.pop();
                while (top != '[') {
                    builder.append(top);
                    top = stack.pop();
                }
                StringBuilder countBuilder = new StringBuilder();
                while (!stack.isEmpty()) {
                    char count = stack.pop();
                    if (isDigit(count)) {
                        countBuilder.append(count);
                    } else {
                        stack.push(count);
                        break;
                    }
                }

                int repeatCount = Integer.valueOf(countBuilder.reverse().toString());
                StringBuilder chunk = new StringBuilder();
                String block = builder.reverse().toString();
                for (int j = 0; j < repeatCount; j++) {
                    chunk.append(block);
                }
                String chunkStr = chunk.toString();
                for (int k = 0; k < chunkStr.length(); k++) {
                    stack.push(chunkStr.charAt(k));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public int calculate(String s) {
        char[] chArr = s.toCharArray();
        int num = 0;
        char sign = '+';
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < chArr.length; i++) {
            char c = chArr[i];
            if (isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if ((!isDigit(c) && c != ' ') || i == chArr.length - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int pre1 = stack.pop();
                        stack.push(pre1 * num);
                        break;
                    case '/':
                        int pre2 = stack.pop();
                        stack.push(pre2 / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private List<String> solution2(TreeNode root) {
        List<String> res = new LinkedList();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> nodes = new LinkedList();
        Deque<String> paths = new LinkedList();
        nodes.offer(root);
        paths.offer(String.valueOf(root.val));
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            String path = paths.poll();
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.left != null) {
                nodes.offer(node.left);
                paths.offer(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                paths.offer(path + "->" + node.right.val);
            }
        }
        return res;
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
