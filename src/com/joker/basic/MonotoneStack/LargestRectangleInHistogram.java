package com.joker.basic.MonotoneStack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {

    }

    // 给定一个非负数组arr，代表直方图，返回直方图的最大长方形面积
    private static int largestRectangle(int[] height) {
        if (height == null || height.length == 0) return 0;

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }
}
