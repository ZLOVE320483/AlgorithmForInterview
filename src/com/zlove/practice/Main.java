package com.zlove.practice;

import com.zlove.practice.tree.TreeNode;
import com.zlove.practice.utils.PrintUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] intervals = {
                {1, 4},
                {1, 4}
        };
        int[][] res = main.merge(intervals);
        for (int[] ii : res) {
            PrintUtils.printList(ii);
        }

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> list = new LinkedList();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                int[] tmp = new int[2];
                tmp[0] = left;
                tmp[1] = intervals[i - 1][1];
                list.add(tmp);
                left = intervals[i][0];
            }
            right = intervals[i][1];
        }
        list.add(new int[] {left, intervals[intervals.length - 1][1]});
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[j] > nums[k] && nums[k] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));
        for (int[] p : points) {
            PrintUtils.printList(p);
        }
        int count = 1;
        int start = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > start) {
                count++;
                start = points[i][1];
            }
        }
        return count;
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p2[0] != p1[0]) {
                return p2[0] - p1[0];
            } else {
                return p1[1] - p2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n) {
                    return true;
                }
            }
        }
        return false;
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
