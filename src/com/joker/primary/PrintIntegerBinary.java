package com.joker.primary;

public class PrintIntegerBinary {
    public static void main(String[] args) {
        int i = 255;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        printBinary(i);
        printBinary(max);
        printBinary(min);

        // 右移分成符号右移和算术右移
        System.out.println("*********************************");
        printBinary(min);
        printBinary(min >> 1); // 复制符号位
        printBinary(min >>> 1); // 仅补0
        System.out.println(min >> 1);
        System.out.println(min >>> 1);

        // 负号可以表示为取反+1: -N = (~N + 1)
        System.out.println("*********************************");
        int a = 5;
        int b = -a;
        int c = (~a + 1);
        printBinary(a);
        printBinary(b);
        printBinary(c);
    }

    /*
    * 输出一个整数的二进制表示，
    * 因为一个整数在java里面都是带符号，而且占四个字节，所以i从31开始
    * 流程：取得第32位是1还是0，所以让1左移32味变成10000~~~000，
    * 如果num和得到的数and后是0，那么该位是0否则是1，输出即可
    *
    * 补码表示：
    * 符号位+数值位
    * 符号位0：正数或0，除去符号位按无符号计算
    * 符号位1：负数，最高的负数减去出去最高位的正数，或者出去符号位取反+1然后变负
    *  */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
