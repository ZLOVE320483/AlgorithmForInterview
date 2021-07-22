package com.zlove.practice.utils;

import java.util.List;

public class PrintUtils {

    public static void printList(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            builder.append(array[i]);
            builder.append(", ");
        }
        builder.append(array[array.length - 1]);
        System.out.println(builder);
    }

    public static void printList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            builder.append(list.get(i));
            builder.append(", ");
        }
        builder.append(list.get(size - 1));
        System.out.println(builder);
    }

    public static void printStringList(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            builder.append(list.get(i));
            builder.append(", ");
        }
        builder.append(list.get(size - 1));
        System.out.println(builder);
    }
}
