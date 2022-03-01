package com.joker.basic.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(permute1("abcc"));
        System.out.println(permute2("abcc"));
    }

    // **********************************

    private static List<String> permute1(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;

        List<Character> rest = new ArrayList<>();
        for (char c : s.toCharArray()) {
            rest.add(c);
        }
        f(rest, "", ans);
        return ans;
    }

    private static void f(List<Character> rest, String path, List<String> ans) {
        if (rest.isEmpty()) {
            ans.add(path);
        } else {
            int N = rest.size();
            for (int i = 0; i < N; i++) {
                char c = rest.get(i);
                rest.remove(i);
                f(rest, path + c, ans);
                rest.add(i, c);
            }
        }
    }

    // ***************************************

    private static List<String> permute2(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;

        char[] chars = s.toCharArray();
        g(chars, 0, ans);

        return ans;
    }

    private static void g(char[] chars, int index, List<String> ans) {
        if (index == chars.length) {
            ans.add(String.valueOf(chars));
        } else {
            // 去重复, 剪枝
            boolean[] visited = new boolean[256];
            for (int i = index; i < chars.length; i++) {
                if (!visited[chars[i]]) {
                    visited[chars[i]] = true;
                    swap(chars, index, i);
                    g(chars, index+1, ans);
                    swap(chars, index, i);
                }
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
