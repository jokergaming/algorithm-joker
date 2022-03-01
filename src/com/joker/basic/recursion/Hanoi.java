package com.joker.basic.recursion;

public class Hanoi {
    public static void main(String[] args) {
        leftToRight(3);
    }

    private static void leftToRight(int n) {
        if (n == 1) {
            System.out.println(1 + " move from left to right");
            return;
        }

        leftToMid(n - 1);
        System.out.println(n + " move from left to right");
        midToRight(n - 1);
    }

    private static void leftToMid(int n) {
        if (n == 1) {
            System.out.println(1 + " move from left to mid");
            return;
        }

        leftToRight(n - 1);
        System.out.println(n + " move from left to mid");
        rightToMid(n - 1);
    }

    private static void rightToMid(int n) {
        if (n == 1) {
            System.out.println(1 + " move from right to mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println(n + " move from right to mid");
        leftToMid(n - 1);
    }

    private static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println(1 + " move from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println(n + " move from right to left");
        midToLeft(n - 1);
    }

    private static void midToLeft(int n) {
        if (n == 1) {
            System.out.println(1 + " move from mid to left");
            return;
        }
        midToRight(n - 1);
        System.out.println(n + " move from mid to left");
        rightToLeft(n - 1);
    }

    private static void midToRight(int n) {
        if (n == 1) {
            System.out.println(1 + " move from mid to right");
            return;
        }
        midToLeft(n - 1);
        System.out.println(n + " move from mid to right");
        leftToRight(n - 1);
    }
}
