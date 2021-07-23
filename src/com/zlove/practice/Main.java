package com.zlove.practice;


import com.zlove.practice.array.OddEvenOrder;
import com.zlove.practice.utils.PrintUtils;

public class Main {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        PrintUtils.printList(OddEvenOrder.oddEvenOrder(a));
    }
}
