package com.joker.primary;

import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int testTime = 100;

        for (int i = 0; i < testTime; i++) {
            int[] arr = genSortArr(100, 10000);
            int target = (int) (Math.random() * 10000 + 1);
            if (binSearch(arr, target) != binSearchFoo(arr, target))
                System.out.println("false");
        }

        for (int i = 0; i < 1000; i++) {
            int[] arr = genSortArr(1000, 50);
            int target = (int) (Math.random() * 50 + 1);
            if (binSearchLeftMost(arr, target) != binSearchLeftMostFoo(arr, target)) {
                System.out.println("false");
                System.out.println("arr[]:" + Arrays.toString(arr));
                System.out.println("target:" + target);
                System.out.println(binSearchLeftMost(arr, target));
                System.out.println(binSearchLeftMostFoo(arr, target));
                break;
            }
        }


        for (int i = 0; i < 1000; i++) {
            int[] arr = genSortArr(1000, 50);
            int target = (int) (Math.random() * 50 + 1);
            if (binSearchRightMost(arr, target) != binSearchRightMostFoo(arr, target)) {
                System.out.println("false");
                System.out.println("right most");
                System.out.println("arr[]:" + Arrays.toString(arr));
                System.out.println("target:" + target);
                System.out.println(binSearchRightMost(arr, target));
                System.out.println(binSearchRightMostFoo(arr, target));
                break;
            }
        }
    }

    // arr找target, 只有找到返回true
    private static boolean binSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return false;

        int L = 0, R = arr.length - 1;

        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                L = mid + 1;
            else R = mid - 1;
        }
        return false;
    }

    // 暴力版本
    private static boolean binSearchFoo(int[] arr, int target) {
        for (int cur : arr) {
            if (cur == target)
                return true;
        }
        return false;
    }

    // 找到arr上>=target最左的位置
    private static int binSearchLeftMost(int[] arr, int target) {
        int ans = -1;

        if (arr == null || arr.length <= 0) return ans;

        int L = 0, R = arr.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] < target)
                L = mid + 1;
            else {
                ans = mid;
                R = mid - 1;
            }
        }
        return ans;
    }

    private static int binSearchLeftMostFoo(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target)
                return i;
        }
        return -1;
    }

    // 找到arr上<= target最右的位置
    private static int binSearchRightMost(int[] arr, int target) {
        int ans = -1;

        if (arr == null || arr.length <= 0) return ans;

        int L = 0, R = arr.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] > target)
                R = mid - 1;
            else {
                ans = mid;
                L = mid + 1;
            }
        }
        return ans;
    }

    private static int binSearchRightMostFoo(int[] arr, int target) {
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target)
                ans = Math.max(ans, i);
        }
        return ans;
    }

    private static int[] genSortArr(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen + 1);
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue + 1);
        }
        Arrays.sort(arr);
        return arr;
    }
}
