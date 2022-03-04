package com.joker.primary;


public class RangeSumDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 9, 7};
        RangeSum1 r1 = new RangeSum1(arr);
        RangeSum2 r2 = new RangeSum2(arr);
        RangeSum3 r3 = new RangeSum3(arr);

        System.out.println(r1.rangeSum(1, 3));
        System.out.println(r2.rangeSum(1, 3));
        System.out.println(r3.rangeSum(1, 3));
    }

    // 循环计算
    static class RangeSum1 {
        private final int[] arr;

        RangeSum1(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum(int L, int R) {
            int sum = 0;
            for (int i = L; i <= R; i++)
                sum += this.arr[i];
            return sum;
        }
    }

    // 前缀和数组
    static class RangeSum2 {
        private final int[] preSum;

        RangeSum2(int[] arr) {
            int N = arr.length;
            preSum = new int[N];
            preSum[0] = arr[0];
            for (int i = 1; i < N; i++)
                preSum[i] = preSum[i-1] + arr[i];
        }

        public int rangeSum(int L, int R) {
            return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
        }
    }

    // 矩阵存储i到j的区间和
    static class RangeSum3 {
        private final int[][] sumMatrix;

        RangeSum3(int[] arr) {
            int N = arr.length;
            this.sumMatrix = new int[N][N];
            for (int i = 0; i < N; i++)
                this.sumMatrix[i][i] = arr[i];

            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    this.sumMatrix[i][j] = this.sumMatrix[i][j-1]+arr[j];
                }
            }
        }

        public int rangeSum(int L, int R) {
            return this.sumMatrix[L][R];
        }
    }
}
