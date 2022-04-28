package com.joker.basic.MonotoneStack;


/* 给定一个只包含正数的数组arr，arr中任何一个子数组sub，
一定都可以算出(sub累加和 )* (sub中的最小值)是什么，
那么所有子数组中，这个值最大是多少？ */

import java.util.Stack;

public class MaxSubSumMulMin {
    public static void main(String[] args) {
        System.out.println(
                maxSubSumMulMin(new int[] {1, 3, 2, 5, 4, 9, 7})
        );
    }

    private static int maxSubSumMulMin(int [] arr) {
        int len = arr.length;
        int[] sums = new int[len];
        sums[0] = arr[0];
        for (int i = 1; i < len; i++)
            sums[i] = sums[i - 1] + arr[i];

        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int j = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sums[len - 1] : (sums[len - 1] - sums[stack.peek()])) * arr[j]);
        }

        return max;
    }
}
