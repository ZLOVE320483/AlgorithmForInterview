package com.zlove.practice.listnode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            int y = 0;
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            carry = sum / 10;
        }

        if (carry != 0) {
            ListNode last = new ListNode(carry);
            cur.next = last;
        }

        return head.next;
    }
}
