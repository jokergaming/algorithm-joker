package com.joker.basic.dp;

public class CardsInLine {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7 };
        System.out.println(maxWinnerScore(arr));
        System.out.println(win3(arr));
    }

    private static int maxWinnerScore(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        return Math.max(f(arr, 0, arr.length - 1),
                g(arr, 0, arr.length - 1));
    }

    private static int f(int[] arr, int L, int R) {
        if (L == R) return arr[L];
        return Math.max(arr[L] + g(arr, L + 1, R), arr[R] + g(arr, L, R - 1));
    }

    private static int g(int[] arr, int L, int R) {
        if (L == R) return 0;
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }


    public static int win3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            fmap[i][i] = arr[i];
        }
        for (int startCol = 1; startCol < N; startCol++) {
            int L = 0;
            int R = startCol;
            while (R < N) {
                fmap[L][R] = Math.max(arr[L] + gmap[L + 1][R], arr[R] + gmap[L][R - 1]);
                gmap[L][R] = Math.min(fmap[L + 1][R], fmap[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
    }
}
