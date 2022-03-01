package com.joker.basic.recursion;

import java.util.HashSet;
import java.util.Set;

public class AllSubStrDeduplication {
    public static void main(String[] args) {
        System.out.println(allSubStrDeduplication("acccc"));
    }

    private static Set<String> allSubStrDeduplication(String str) {
        if (str == null || str.length() == 0) return null;

        // 利用set可以去重复，防止重复元素加入
        Set<String> ans = new HashSet<>();
        process(str, 0, ans, "");

        return ans;
    }

    private static void process(String str, int index, Set<String> ans, String genPath) {
        if (index == str.length()) {
            ans.add(genPath);
            return;
        }

        process(str, index+1, ans, genPath);
        process(str, index+1, ans, genPath + str.charAt(index));
    }
}
