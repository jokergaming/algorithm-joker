package com.joker.primary;

import java.util.Arrays;

import static com.joker.primary.SelectionSort.swap;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        /*
        * 0 - N
        * 0 - N-1
        * 0 - N-2
        * end: n, n - 1, n - 2 */
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                /*
                * 0 - j
                * 0 1       1 2          2 3          3 4 */
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }
}
