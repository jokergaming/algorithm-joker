package com.joker.primary;

import java.util.Arrays;

/*
* 局部最小值问题,
* 任意两个相邻的数均不等，
* 找出一个局部最小。
* 0位置小于1：返回0位置
* n-1位置小于n-2：返回n-2
* 中间位置必须小于两侧
* 只需要返回一个局部最小的位置 */
public class LocalMinimum {
    public static void main(String[] args) {
        int maxLen = 1000;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = genRandom(maxLen, maxValue);
            int ans = localMin(arr);
            if (!check(arr, ans)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }

    private static int localMin(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int N = arr.length;
        if (N == 1) return 0;
        if (arr[0] < arr[1]) return 0;
        if (arr[N-1] < arr[N-2]) return N-1;
        int L = 0, R = N-1;
        // L和R之间必须存在局部最小，保证三个数，如果是L <= R，会出现越界，如arr = [3 2 3 2 3]
        while (L < R-1) {
            int mid = L + (R - L) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1])
                return mid;
            else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }


    // 生成随机数组，且相邻数不相等
    private static int[] genRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen + 1);
        int[] arr = new int[len];

        arr[0] = (int) (Math.random() * maxValue + 1);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue + 1);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    private static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) return minIndex == -1;

        int left = minIndex - 1;
        int right = minIndex + 1;

        boolean leftBigger = left < 0 || arr[left] > arr[minIndex];
        boolean rightBigger = right > arr.length - 1 || arr[right] > arr[minIndex];
        return leftBigger && rightBigger;
    }


}
