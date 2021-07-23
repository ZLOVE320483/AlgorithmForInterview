package com.zlove.practice.array;

public class OddEvenOrder {

    public static int[] oddEvenOrder(int[] source) {
        int i = 0, j = source.length - 1;
        int[] res = new int[source.length];
        for (int k = 0; k < source.length; k++) {
            if (source[k] % 2 != 0) {
                res[i] = source[k];
                i++;
            } else {
                res[j] = source[k];
                j--;
            }
        }
        return res;
    }
}
