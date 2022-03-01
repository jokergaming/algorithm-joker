package com.joker.basic.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubStr {
    public static void main(String[] args) {
        System.out.println(getAllSubStr("abbb"));
    }

    private static List<String> getAllSubStr(String str) {
        if (str == null || str.length() == 0) return null;
        List<String> ans = new ArrayList<>();

        process(str, 0, ans, "");
        return ans;
    }

    private static void process(String str, int index, List<String> ans, String generatePath) {
        if (index == str.length()) {
            ans.add(generatePath);
            return;
        }
        process(str, index + 1, ans, generatePath);
        process(str, index + 1, ans, generatePath + str.charAt(index));
    }
}
