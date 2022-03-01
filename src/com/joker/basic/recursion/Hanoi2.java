package com.joker.basic.recursion;

public class Hanoi2 {
    public static void main(String[] args) {
        hanoi(3, "a", "c", "b");
    }

    /*
    * n: 多少个圆盘
    * from: 从哪个开始移动
    * to: 移到哪里去
    * other: 中间经过哪个
    *  */
    private static void hanoi(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println(n + " move from " + from + " to " + to);
            return;
        }
        hanoi(n - 1, from, other, to);
        System.out.println(n + " move from " + from + " to " + to);
        hanoi(n - 1, other, to, from);
    }
}
