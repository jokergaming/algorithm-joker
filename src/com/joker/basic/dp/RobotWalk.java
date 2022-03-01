package com.joker.basic.dp;

/*
 假设有排成一行的N个位置记为1~N，N一定大于或等于2
 开始时机器人在其中的M位置上(M一定是1~N中的一个)
 如果机器人来到1位置，那么下一步只能往右来到2位置；
 如果机器人来到N位置，那么下一步只能往左来到N-1位置；
 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 给定四个参数 N、M、K、P，返回方法数
*/

public class RobotWalk {
    public static void main(String[] args) {
        System.out.println(ways1(5, 2, 6, 4));
        System.out.println(ways2(5, 2, 6, 4));
        System.out.println(ways3(5, 2, 6, 4));
    }


    // 暴力递归
    private static int ways1(int N, int start, int K, int aim) {
        if (N < 2 || start < 1 || start > N || K < 0 || aim < 1 || aim > N)
            return -1;

        return f(N, start, K, aim);
    }

    private static int f(int N, int cur, int remainWalk, int aim) {
        if (remainWalk == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) return f(N, 2, remainWalk - 1, aim);
        else if (cur == N) return f(N, N - 1, remainWalk - 1, aim);
        else return f(N, cur - 1, remainWalk - 1, aim) + f(N, cur + 1, remainWalk - 1, aim);
    }

    // 记忆化搜索
    private static int ways2(int N, int start, int K, int aim) {
        if (N < 2 || start < 1 || start > N || K < 0 || aim < 1 || aim > N)
            return -1;

        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++)
                dp[i][j] = -1;
        }

        return f2(N, start, K, aim, dp);
    }

    private static int f2(int N, int cur, int remain, int aim, int[][] dp) {
        if (dp[cur][remain] != -1) return dp[cur][remain];

        int ans = 0;
        if (remain == 0) return cur == aim ? 1 : 0;
        else if (cur == 1) ans = f2(N, 2, remain - 1, aim, dp);
        else if (cur == N) ans = f2(N, N - 1, remain - 1, aim, dp);
        else ans = f2(N, cur - 1, remain - 1, aim, dp)
                    + f2(N, cur + 1, remain - 1, aim, dp);
        dp[cur][remain] = ans;
        return ans;
    }

    // 直接构造dp数组
    private static int ways3(int N, int start, int rest, int aim) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || rest < 0)
            return -1;

        int[][] dp = new int[N + 1][rest + 1];

        dp[aim][0] = 1;
        for (int j = 1; j <= rest; j++) {
            dp[1][j] = dp[2][j - 1];
            for (int i = 2; i < N; i++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i + 1][j - 1];
            }
            dp[N][j] = dp[N - 1][j - 1];
        }
        return dp[start][rest];
    }
}
