package com.joker.basic.unionfind;

import java.util.*;

public class NumberOfIslands {
    // dfs实现
    public int numIslands1(char[][] grids) {
        int ans = 0;

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] == '1') {
                    ans++;
                    dfs(grids, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grids, int i, int j) {
        if (i >= grids.length || i < 0 || j >= grids[0].length || j < 0 || grids[i][j] != '1')
            return;
        grids[i][j] = 2;
        dfs(grids, i+1, j);
        dfs(grids, i-1, j);
        dfs(grids, i, j+1);
        dfs(grids, i, j-1);
    }

    // *******************************************

    private static class Dot {} // 辅助类，为了区分不同位置的1

    private static class Node<T> {
        T value;
        Node(T v) {
            value = v;
        }
    }

    private static class UnionFind1<T> {
        Map<T, Node<T>> nodes;
        Map<Node<T>, Node<T>> parents;
        Map<Node<T>, Integer> sizeMap;

        UnionFind1(List<T> list) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (T v : list) {
                Node<T> cur = new Node<>(v);
                this.nodes.put(v, cur);
                this.parents.put(cur, cur);
                this.sizeMap.put(cur, 1);
            }
        }

        Node<T> findFather(Node<T> x) {
            Stack<Node<T>> stack = new Stack<>();

            while (this.parents.get(x) != x) {
                stack.push(x);
                x = this.parents.get(x);
            }

            while (!stack.isEmpty()) {
                this.parents.put(stack.pop(), x);
            }

            return x;
        }

        void union(T x, T y) {
            Node<T> f1 = findFather(this.nodes.get(x));
            Node<T> f2 = findFather(this.nodes.get(y));

            if (f1 != f2) {
                Integer size1 = this.sizeMap.get(f1);
                Integer size2 = this.sizeMap.get(f2);
                Node<T> big = size1 > size2 ? f1 : f2;
                Node<T> small = big == f1 ? f2 : f1;
                this.parents.put(small, big);
                this.sizeMap.put(big, size1 + size2);
                this.sizeMap.remove(small);
            }
        }

        int sets() {
            return this.sizeMap.size();
        }
    }

    public int numIslands2(char[][] grids) {
        int row = grids.length;
        int column = grids[0].length;

        Dot[][] dots = new Dot[row][column];
        List<Dot> dotList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grids[i][j] == '1') {
                    dots[i][j] = new Dot();
                    dotList.add(dots[i][j]);
                }
            }
        }

        UnionFind1<Dot> uf = new UnionFind1<>(dotList);
        for (int j = 1; j < column; j++) {
            if (grids[0][j - 1] == '1' && grids[0][j] == '1')
                uf.union(dots[0][j- 1], dots[0][j]);
        }
        for (int i = 1; i < row; i++) {
            if (grids[i - 1][0] == '1' && grids[i][0] == '1')
                uf.union(dots[i - 1][0], dots[i][0]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (grids[i][j] == '1') {
                    if (grids[i - 1][j] == '1')
                        uf.union(dots[i-1][j], dots[i][j]);
                    if (grids[i][j-1] == '1')
                        uf.union(dots[i][j -1], dots[i][j]);
                }
            }
        }
        return uf.sets();
    }

    // *******************************************

    private static class UnionFind2 {
        private final int[] parent;
        private final int[] size;
        private final int[] helper;
        private final int col;
        private int sets;

        private int index(int r, int c) {
            return r * this.col + c;
        }

        UnionFind2(char[][] grids) {
            this.col = grids[0].length;
            sets = 0;

            int row = grids.length;
            int len = this.col * row;

            this.parent = new int[len];
            this.size = new int[len];
            this.helper = new int[len];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < this.col; j++) {
                    if (grids[i][j] == '1') {
                        int idx = index(i, j);
                        this.parent[idx] = idx;
                        this.size[idx] = 1;
                        this.sets++;
                    }
                }
            }
        }

        int findFather(int i) {
            int top = 0;

            while (i != this.parent[i]) {
                this.helper[top++] = i;
                i = this.parent[i];
            }
            for (top--; top >= 0; top--) {
                this.parent[this.helper[top]] = i;
            }

            return i;
        }

        void union(int r1, int c1, int r2, int c2) {
            int i1 = index(r1, c1);
            int i2 = index(r2, c2);
            int f1 = this.parent[i1];
            int f2 = this.parent[i2];
            if (f1 != f2) {
                int size1 = this.size[f1];
                int size2 = this.size[f2];
                if (size1 >= size2) {
                    this.parent[f2] = f1;
                    this.size[f1] += this.size[f2];
                } else {
                    this.parent[f1] = f2;
                    this.size[f2] += this.size[f1];
                }
                this.sets--;
            }
        }

        public int getSets() {
            return sets;
        }
    }

    public int numIsland2(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        UnionFind2 uf = new UnionFind2(grid);
        for (int i = 1; i < row; i++) {
            if (grid[i - 1][0] == '1' && grid[i][0] == '1')
                uf.union(i-1, 0, i, 0);
        }
        for (int j = 1; j < col; j++) {
            if (grid[0][j - 1] == '1' && grid[0][j] == '1')
                uf.union(0, j-1, 0, j);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] == '1' && grid[i - 1][j] == '1')
                    uf.union(i, j, i - 1, j);
                if (grid[i][j] == '1' && grid[i][j - 1] == '1')
                    uf.union(i, j, i, j - 1);
            }
        }

        return uf.getSets();
    }
}
