package com.zlove.practice.tanxin;

import java.util.Arrays;

public class FindContentChildren {

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        FindContentChildren findContentChildren = new FindContentChildren();
        System.out.println(findContentChildren.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int countOfChild = g.length;
        int countOfCook = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < countOfChild && j < countOfCook; i++, j++) {
            while (j < countOfCook && s[j] < g[i]) {
                j++;
            }
            if (j < countOfCook) {
                count++;
            }
        }
        return count;
    }
}
