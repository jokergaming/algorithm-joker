package com.joker.ds;

public class DoubleListNode {
    public int val;
    public DoubleListNode pre;
    public DoubleListNode next;

    public DoubleListNode(int val) { this.val = val; }
    public DoubleListNode(int val, DoubleListNode pre, DoubleListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    public static DoubleListNode reverseDList(DoubleListNode head) {
        DoubleListNode next = null, pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
