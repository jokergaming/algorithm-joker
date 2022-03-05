package com.joker.primary;

public class RandToRand {
    public static void main(String[] args) {
        int testTime = 10000000;
        int count = 0;
        int[] counts = new int[10];

        System.out.println("-------------------------");

        // math.random()等概率返回[0,1)上的数
        for (int i = 0; i < testTime; i++) {
            if (Math.random() < 0.5)
                count++;
        }
        // 返回0.5，验证成功
        System.out.println((double) count / (double) testTime);

        System.out.println("-------------------------");

        // math.random() * k 返回[0, k)等概率
        count = 0;
        for (int i = 0; i < testTime; i++) {
            if (Math.random() * 10 < 5)
                count++;
        }
        System.out.println((double) count / (double) testTime);

        System.out.println("-------------------------");
        // math.random() + k返回[k, k+1)上的数
        count = 0;
        for (int i = 0; i < testTime; i++) {
            if (Math.random() + 5 < 5.5)
                count++;
        }
        System.out.println((double) count / (double) testTime);

        System.out.println("-------------------------");
        count = 0;
        for (int i = 0; i < testTime; i++) {
            if (pxToPower2() < 0.5)
                count++;
        }
        // 结果是0.25，验证了函数
        System.out.println((double) count / (double) testTime);

        System.out.println("-------------------------");
        count = 0;
        for (int i = 0; i < testTime; i++) {
            if (pxToPower(3) < 0.5)
                count++;
        }
        // 结果是0.125 = 0.5^3
        System.out.println((double) count / (double) testTime);

    }

    // math.random() 返回[0, 1)上的数，math.random() < 0.3的概率为0.3, < 1的概率为1
    // 如何让一个函数等概率返回，且 < x 的概率是x^2?
    // 可以利用概率乘法公式
    private static double pxToPower2() {
        // 如果返回 < 0.3, 那么两个随机事件必然都要 < 0.3
        // p(ab) = p(a)  * p(b), 所以说返回概率由x变成x^2
        // 如果是math.min, 会返回1-(1-x)^2
        return Math.max(Math.random(), Math.random());
    }

    private static double pxToPower(int n) {
        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.random());
        }
        return ans;
    }
}
