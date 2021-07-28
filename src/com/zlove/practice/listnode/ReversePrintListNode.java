package com.zlove.practice.listnode;

import java.util.ArrayList;
import java.util.List;

public class ReversePrintListNode {

    public int[] reversePrint(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            nodes.add(cursor.val);
            cursor = cursor.next;
        }
        int[] res = new int[nodes.size()];
        for (int i = nodes.size() - 1, j = 0; i >= 0; i--, j++) {
            res[j] = nodes.get(i);
        }
        return res;
    }
}
