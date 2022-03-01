package com.joker.basic.unionfind;

import java.util.*;

public class UnionFindDemo {
    public static void main(String[] args) {
        List<String> list = List.of("hello", "world", "this", "is", "me");
        UnionFind<String> union = new UnionFind<>(list);
        union.union("hello", "world");
        System.out.println(union.isSameSet("hello", "world"));
        System.out.println(union.isSameSet("hello", "this"));
    }

    private static class Node<T> {
        T val;

        public Node(T val) {
            this.val = val;
        }
    }

    static class UnionFind<T> {
        // 每个值对应的节点
        Map<T, Node<T>> nodes;
        // 每个节点对应的父亲
        Map<Node<T>, Node<T>> parents;
        // 如果是代表节点，那么就会有整个一团的大小
        Map<Node<T>, Integer> sizeMap;

        public UnionFind(List<T> vals) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMap = new HashMap<>();

            for (T val : vals) {
                Node<T> node = new Node<>(val);
                this.nodes.put(val, node);
                this.parents.put(node, node);
                this.sizeMap.put(node, 1);
            }
        }

        public Node<T> findFather(Node<T> cur) {
            Stack<Node<T>> stack = new Stack<>();

            while (this.parents.get(cur) != cur) {
                stack.push(cur);
                cur = this.parents.get(cur);
            }

            while (!stack.isEmpty()) {
                this.parents.put(stack.pop(), cur);
            }

            return cur;
        }

        public boolean isSameSet(T a, T b) {
            return findFather(this.nodes.get(a)) == findFather(this.nodes.get(b));
        }

        public void union(T a, T b) {
            Node<T> aF = findFather(this.nodes.get(a));
            Node<T> bF = findFather(this.nodes.get(b));

            if (aF != bF) {
                int aSetSize = this.sizeMap.get(this.nodes.get(a));
                int bSetSize = this.sizeMap.get(this.nodes.get(b));
                Node<T> big = aSetSize > bSetSize ? aF : bF;
                Node<T> small = big == aF ? bF : aF;
                this.parents.put(small, big);
                this.sizeMap.put(big, aSetSize + bSetSize);
                this.sizeMap.remove(small);
            }
        }

        public int size() {
            return this.sizeMap.size();
        }
    }
}
