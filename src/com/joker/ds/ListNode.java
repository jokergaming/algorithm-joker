package com.joker.ds;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class MyQueue {
    ListNode head;
    ListNode tail;
    int size;

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        System.out.println(q.isEmpty());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q.size);

        while (!q.isEmpty())
            System.out.println(q.poll());
    }

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(int val) {
        ListNode node = new ListNode(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    public int poll() {
        int ans = 0;
        if (head == null) {
            throw new RuntimeException("queue is empty");
        } else {
            ans = head.val;
            head = head.next;
            size--;
        }
        if (head == null) {
            tail = null;
        }
        return ans;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else {
            return head.val;
        }
    }
}
