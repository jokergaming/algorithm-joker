package com.joker.basic.greedy;

/*
* 给定一个由字符串组成的数组strs，
* 必须把所有的字符串拼接起来，
* 返回所有可能的拼接结果中字典序最小的结果
*  */

import java.util.Arrays;
import java.util.TreeSet;

public class LowestLexicography {
    public static void main(String[] args) {
        // String[] test = {"hello", "world", "this", "can", "be"};
        // System.out.println(lowestString1(test));
        // System.out.println(lowestString2(test));

        // for (int i = 0; i < 10; i++) {
        //     System.out.println(generateRandomString(10));
        // }

        int arrLen = 6;
        int strLen = 5;
        int testTimes = 10000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String[] arr1 = generateRandomStringArr(arrLen, strLen);
            String[] arr2 = copyStringArray(arr1);
            if (!lowestString1(arr1).equals(lowestString2(arr2))) {
                for (String str : arr1) {
                    System.out.print(str + ",");
                }
                System.out.println();
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }


    // 暴力求解
    public static String lowestString1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        TreeSet<String> ans = process(strs);
        return ans.size() == 0 ? "" : ans.first();
    }

    public static String[] removeIndexString(String[] strs, int index) {
        String[] ans = new String[strs.length - 1];

        int cur = 0;
        for (int i = 0; i < strs.length; i++) {
            if (i != index) {
                ans[cur++] = strs[i];
            }
        }

        return ans;
    }

    // 全排列，返回所有可能结果
    public static TreeSet<String> process(String[] strs) {
        TreeSet<String> ans = new TreeSet<>();

        if (strs.length == 0) {
            ans.add("");
            return ans;
        }
        for (int i = 0; i < strs.length; i++) {
            String first = strs[i];
            String[] nexts = removeIndexString(strs, i);
            TreeSet<String> next = process(nexts);
            for (String cur : next) {
                ans.add(first + cur);
            }
        }

        return ans;
    }

    // 贪心
    public static String lowestString2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs, (s1, s2) -> ((s1 + s2).compareTo(s2 + s1)));
        StringBuilder res = new StringBuilder();
        for (String str : strs) res.append(str);
        return res.toString();
    }

    public static String generateRandomString(int maxlen) {
        char[] ans = new char[(int) (Math.random() * maxlen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 5);
            ans[i] = (Math.random() <= 0.5) ? (char) (65 + value) : (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    public static String[] generateRandomStringArr(int arrMaxLen, int maxStrLen) {
        String[] ans = new String[(int) (Math.random() * arrMaxLen) + 1];
        for (int i = 0; i < ans.length; i++)
            ans[i] = generateRandomString(maxStrLen);
        return ans;
    }

    public static String[] copyStringArray(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = String.valueOf(arr[i]);
        }
        return ans;
    }
}
