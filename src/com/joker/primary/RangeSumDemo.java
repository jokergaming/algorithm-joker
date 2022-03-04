package com.joker.primary;



public class RangeSumDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 9, 7};
        RangeSum1 r1 = new RangeSum1(arr);
        RangeSum2 r2 = new RangeSum2(arr);

        System.out.println(r1.rangeSum(1, 3));
        System.out.println(r2.rangeSum(1, 3));
    }

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
}
