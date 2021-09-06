package com.zlove.practice.listnode;

/**
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            ListNode next = l2.next;

            pre.next = l2;
            l2.next = l1;
            l1.next = next;

            pre = l1;
        }
        return node.next;
    }
}
