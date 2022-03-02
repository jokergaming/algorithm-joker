package com.joker.basic.dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
        int[] values = { 5, 6, 3, 19, 12, 4, 2 };
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dpMaxValue(weights, values, bag));
    }

    private static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0 || bag < 0)
            return 0;

        return f(w, v, 0, bag);
    }

    // 暴力实现
    private static int f(int[] w, int[] v, int index, int rest) {
        if (rest < 0)
            return -1;
        if (index == w.length)
            return 0;

        // 背包有东西，还没到最后
        int p1 = f(w, v, index + 1, rest);
        int p2 = 0;
        int next = f(w, v, index + 1, rest - w[index]);
        if (next != -1)
            p2 = v[index] + f(w, v, index+1, rest - w[index]);

        return Math.max(p1, p2);
    }

    private static int dpMaxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0 || bag < 0)
            return 0;

        int N = w.length;
        int[][] dp = new int[N+1][bag+1];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= bag; j++) {
                int p1 = dp[i+1][j];
                int p2 = 0;
                int next = j - w[i] < 0 ? -1 : dp[i+1][j - w[i]];
                if (next != -1)
                    p2 = v[i] + dp[i+1][j - w[i]];
                dp[i][j] = Math.max(p1, p2);
            }
        }

        return dp[0][bag];
    }
}
