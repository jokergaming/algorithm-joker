package com.joker.basic.recursion;

public class ReverseNum {
    public static void main(String[] args) {
        System.out.println(reverse(32133));
    }

    private static int reverse(int num) {
        // 如果num是个位数，不需要翻转
        if (num / 10 == 0) return num;

        // 123会取12翻转，成为21 只要把3加到前面就会成为321
        int n1 = reverse(num / 10);
        int n2 = num % 10;

        int n3 = n1;
        while (n3 > 0) {
            n2 *= 10;
            n3 /= 10;
        }
        return n2 + n1;
    }
}
