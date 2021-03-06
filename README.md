# algorithm-joker

系统记录下自己学习的算法和数据结构，做好总结，主要是一些初级内容

## 简单算法
1. [整数转二进制](./src/com/joker/primary/PrintIntegerBinary.java)
2. [阶乘累加和](./src/com/joker/primary/SumOfFactorial.java)
3. [前缀和类](./src/com/joker/primary/RangeSumDemo.java)
4. [选择排序](./src/com/joker/primary/SelectionSort.java)
5. [冒泡排序](./src/com/joker/primary/BubbleSortDemo.java)
6. [插入排序](./src/com/joker/primary/InsertionSort.java)


## 基础算法体系
* [贪心](./src/com/joker/basic/greedy)
  * [字符串拼接字典序最小](./src/com/joker/basic/greedy/LowestLexicography.java)
  * [最多开会次数的会议室](./src/com/joker/basic/greedy/BestArrange.java)
  
* [并查集](./src/com/joker/basic/unionfind)
  * [哈希表实现并查集](./src/com/joker/basic/unionfind/UnionFindDemo.java):常数时间比较慢，但好理解
  * [省份数量](./src/com/joker/basic/unionfind/FindCircleNumber.java)——[leetcode地址](https://leetcode-cn.com/problems/number-of-provinces)
  * [岛屿个数1](./src/com/joker/basic/unionfind/NumberOfIslands.java)——[leetcode地址](https://leetcode-cn.com/problems/number-of-islands)

* [递归过程](./src/com/joker/basic/recursion)
  * [递归实现汉诺塔(1)](./src/com/joker/basic/recursion/Hanoi.java)——朴素方法，六个函数
  * [递归实现汉诺塔(2)](./src/com/joker/basic/recursion/Hanoi2.java)——递归函数可以通过增加参数来进一步抽象
  * [字符串所有子序列，不去重](./src/com/joker/basic/recursion/AllSubStr.java)
  * [字符串所有子序列，去重](./src/com/joker/basic/recursion/AllSubStrDeduplication.java)——利用set去重
  * [字符串所有排列](./src/com/joker/basic/recursion/Permutation.java)
  * [递归逆序栈](./src/com/joker/basic/recursion/ReverseStack.java)
  * [递归逆序数字](./src/com/joker/basic/recursion/ReverseNum.java)
  * [八皇后](./src/com/joker/basic/recursion/NQueen.java)
  
* [动态规划](./src/com/joker/basic/dp)
  * [机器人走路的方法](./src/com/joker/basic/dp/RobotWalk.java)
  * [两人打牌博弈](./src/com/joker/basic/dp/CardsInLine.java)
  * [背包问题](./src/com/joker/basic/dp/Knapsack.java)
  * [数字字符串转字母](./src/com/joker/basic/dp/ConvertToLetterString.java)
  * [沿途最小路径和](./src/com/joker/basic/dp/MinPathSum.java)