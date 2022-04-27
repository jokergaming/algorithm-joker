package com.joker.basic.dp;

public class MinSepSetSum {
    public static void main(String[] args) {
        System.out.println(
                minSeqSetSumRec(new int[]{2, 5, 7, 3})
        );
        System.out.println(
                minSeqSetSumDp(new int[]{2, 5, 7, 3})
        );
    }

    private static int minSeqSetSumDp(int[] arr) {
        if (arr == null || arr.length < 2) return 0;

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        sum /= 2;

        int len = arr.length;
        int[][] dp = new int[arr.length + 1][sum + 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = sum; j >= 0; j--) {
                int p1 = dp[i + 1][j];
                int p2 = Integer.MIN_VALUE;
                if (j >= arr[i]) {
                    p2 = arr[i] + dp[i+1][j - arr[i]];
                }
                dp[i][j] = Math.max(p1, p2);
            }
        }

        return dp[0][sum];
    }

    // 给定一个正数数组arr，
    // 请把arr中所有的数分成两个集合，尽量让两个集合的累加和接近
    // 返回最接近的情况下，较小集合的累加和
    private static int minSeqSetSumRec(int[] arr) {
        // 如果数组不存在，或者数组长度小与2，无法分成两个集合，
        // 直接返回0
        if (arr == null || arr.length < 2) return 0;

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        sum /= 2;

        return f(arr, 0, sum);
    }

    // f返回从index开始，要或者不要arr中的元素，最大的小于aim的元素和
    private static int f(int[] arr, int index, int aim) {
        if (index == arr.length) return 0;

        int p1 = f(arr, index + 1, aim);
        int p2 = Integer.MIN_VALUE;
        if (aim >= arr[index]) {
            p2 = arr[index] + f(arr, index + 1, aim - arr[index]);
        }

        return Math.max(p1, p2);
    }
}
