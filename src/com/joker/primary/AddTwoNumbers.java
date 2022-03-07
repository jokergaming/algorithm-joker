package com.joker.primary;

import com.joker.ds.ListNode;

// https://leetcode-cn.com/problems/add-two-numbers/submissions/

public class AddTwoNumbers {
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;

        // 获取两个链表的长度
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        // 重定向
        ListNode l = len1 > len2 ? l1 : l2;
        ListNode s = l == l1 ? l2 : l1;
        ListNode pl = l;
        ListNode ps = s;
        // 追踪节点
        ListNode pre = null;
        int carry = 0;
        int cur = 0;

        while (ps != null) {
            cur = pl.val + ps.val + carry;
            pl.val = cur % 10;
            carry = cur / 10;
            pre = pl;
            ps = ps.next;
            pl = pl.next;
        }

        while (pl != null) {
            cur = pl.val + carry;
            pl.val = cur;
            pre= pl;
            pl = pl.next;
        }

        if (carry > 0) {
            pre.next = new ListNode(carry);
        }

        return l;
    }

    private static int getLength(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }
}
