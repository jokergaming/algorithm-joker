package com.joker.basic.unionfind;

public class FindCircleNumber {
    // 并查集类
    private static class UnionFind {
        int[] parents;
        int[] size;
        // 寻找代表节点需要把沿途所有节点入栈
        int[] helper;
        int sets;

        // 一开始每个圈子互相独立，共有n个集合，每个集合代表节点都是自己，每个集合的size=1
        public UnionFind(int N) {
            this.parents = new int[N];
            this.size = new int[N];
            this.helper = new int[N];

            for (int i = 0; i < N; i++) {
                this.parents[i] = i;
                this.size[i] = 1;
            }
            this.sets = N;
        }

        // 寻找代表节点
        public int findFather(int x) {
            int top = 0;

            while (x != this.parents[x]) {
                this.helper[top++] = x;
                x = this.parents[x];
            }
            for (top--; top >= 0; top--) {
                this.parents[this.helper[top]] = x;
            }

            return x;
        }

        public void union(int x, int y) {
            int f1 = findFather(x);
            int f2 = findFather(y);

            if (f1 != f2) {
                int size1 = this.size[f1];
                int size2 = this.size[f2];
                int big = size1 > size2 ? f1 : f2;
                int small = big == f1 ? f2 : f1;
                this.parents[small] = big;
                this.size[big] = size1 + size2;
                this.sets--;
            }
        }

        public int getSets() {
            return sets;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind(isConnected.length);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.getSets();
    }
}
