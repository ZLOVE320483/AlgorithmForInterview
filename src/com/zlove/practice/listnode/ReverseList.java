package com.zlove.practice.listnode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

    /**
     * 非递归算法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归算法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
