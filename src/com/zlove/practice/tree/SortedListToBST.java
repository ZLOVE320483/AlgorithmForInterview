package com.zlove.practice.tree;

import com.zlove.practice.listnode.ListNode;

public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = head;
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = pre.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
