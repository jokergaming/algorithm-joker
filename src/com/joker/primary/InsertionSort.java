package com.joker.primary;

import java.util.Arrays;

import static com.joker.primary.SelectionSort.swap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        // insertionSort(arr);
        insertionSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        /*
        * 0 - 0
        * 0 - 1
        * 0 - 2
        * 0 - 3 */
        for (int end = 1; end < arr.length; end++) {
            // 当前来到的位置
            int newNumIndex = end;
            // 不断往左看，如果左边数大于，交换，当前看的数变成移过去的位置
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex, newNumIndex - 1);
                newNumIndex--;
            }
        }
    }

    public static void insertionSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 1; i < arr.length; i++) {
            for (int pre = i - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--)
                swap(arr, pre, pre + 1);
        }
    }
}
