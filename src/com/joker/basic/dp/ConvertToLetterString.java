package com.joker.basic.dp;

public class ConvertToLetterString {
    public static void main(String[] args) {
        System.out.println(convertNum("111"));
        System.out.println(convertNum("1211"));
        /*
        * 1 2 1 1
        * 1 2 11
        * 1 21 1
        * 12 1 1
        * 12 11
        *  */
    }

    private static int convertNum(String numStr) {
        if (numStr == null || numStr.length() == 0) return 0;

        return f(numStr.toCharArray(), 0);
    }

    private static int f(char[] strs, int index) {
        if (index == strs.length) return 1;

        int res = f(strs, index + 1);
        if (index + 1 < strs.length && (strs[index] - '0') * 10 + (strs[index + 1] - '0') < 27) {
            res += f(strs, index + 2);
        }

        return res;
    }
}
