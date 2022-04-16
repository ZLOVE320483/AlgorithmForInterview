package com.zlove.practice;

public class Main {

    public static void main(String[] args) {
        String aa = "abcdef";
        aa.contains("ac");
        System.out.println(aa.substring(0, 2));
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
