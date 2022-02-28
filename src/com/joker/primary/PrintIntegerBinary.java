package com.joker.primary;

public class PrintIntegerBinary {
    public static void main(String[] args) {
        int i = 255;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        printBinary(i);
        printBinary(max);
        printBinary(min);
        printBinary(1 << 1);
        printBinary(1 << 3);
        printBinary(1 << 8);
    }

    /*
    * 输出一个整数的二进制表示，
    * 因为一个整数在java里面都是带符号，而且占四个字节，所以i从31开始
    * 流程：取得第32位是1还是0，所以让1左移32味变成10000~~~000，
    * 如果num和得到的数and后是0，那么该位是0否则是1，输出即可
    *  */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
