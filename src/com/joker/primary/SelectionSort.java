package com.joker.primary;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    * 选择排序：
    * 0到n-1选出最小的数和0位置交换，0位置确定
    * 1到n-1选出最小的数和1位置交换，1位置确定
    * 不断重复，直到倒数第一个数确定
    *  */
    public static void selectionSort(int[] arr) {
        // 先思考边界条件
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) min = j;
            }
            swap(arr, i, min);
        }
    }

    // public static void selectionSort2(int[] arr) {
    //     if (arr == null || arr.length < 2) return;
    //
    //     /*
    //     * 0-n-1
    //     * 1-n-1
    //     * 2-n-1
    //     */
    //     for (int i = 0; i < arr.length; i++) {
    //         int minIndex = i;
    //         for (int j = i+1; j < arr.length; j++)
    //             minIndex = arr[j] < arr[minIndex] ? j : minIndex;
    //         swap(arr, i, minIndex);
    //     }
    // }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
