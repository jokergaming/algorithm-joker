package com.joker.basic.recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);

        reverse(s);

        while (!s.isEmpty())
            System.out.println(s.pop());
    }

    // 返回栈底元素
    /*
    * stack = [1, 2, 3]
    * 1. r = 1, last = f([2, 3])
    * 2. r = 2, last = f([3])
    * 3. r = 3 -> return
    *  */
    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }
}
