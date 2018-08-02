package beibaowenti;

import java.util.Arrays;

/**
 * 
 * 有一个背包，背包容量是M=150。有7个物品，物品可以分割成任意大小。
*要求尽可能让装入背包中的物品总价值最大，但不能超过总容量。
*物品 A B C D E F G
*重量 35 30 60 50 40 10 25
*价值 10 40 30 50 35 40 30
*记得当时学算法的时候，就是这个例子，可以说很经典。
*分析：
*目标函数： ∑pi最大
*约束条件是装入的物品总重量不超过背包容量，即∑wi<=M( M=150)
*（1）根据贪心的策略，每次挑选价值最大的物品装入背包，得到的结果是否最优？
*（2）每次挑选所占重量最小的物品装入是否能得到最优解？
*（3）每次选取单位重量价值最大的物品，成为解本题的策略?
*贪心算法是很常见的算法之一，这是由于它简单易行，构造贪心策略简单。但是，它需要证明后才能真正运用到题目的算法中。一般来说，贪心算法的证明围绕着整个问题的最优解一定由在贪心策略中存在的子问题的最优解得来的。
*对于本例题中的3种贪心策略，都无法成立，即无法被证明，解释如下：
*（1）贪心策略：选取价值最大者。反例：
*W=30
*物品：A B C
*重量：28 12 12
*价值：30 20 20
*根据策略，首先选取物品A，接下来就无法再选取了，可是，选取B、C则更好。
*（2）贪心策略：选取重量最小。它的反例与第一种策略的反例差不多。
*（3）贪心策略：选取单位重量价值最大的物品。反例：
*W=30
*物品：A B C
*重量：28 20 10
*价值：28 20 10
*根据策略，三种物品单位重量价值一样，程序无法依据现有策略作出判断，如果选择A，则答案错误。 
 * @author hasee
 *
 */

/**
 * https://blog.csdn.net/u014394715/article/details/51162960
 * 
 * 综上所述，背包问题的解法不应该是使用贪心算法，而是应该使用动态规划算法
 * 动态规划背后的基本思想非常简单。大致上，若要解一个给定问题，我们需要解其不同部分（即子问题），再合并子问题的解以得出原问题的解。
 * 从空集合开始，每增加一个元素就求它的最优解，直到所有元素加进来，就得到了总的最优解。
 * 
 * 问题：有编号分别为a,b,c,d,e的五件物品，它们的重量分别是2,2,6,5,4，它们的价值分别是6,3,5,4,6，现在给你个承重为10的背包，
 * 如何让背包里装入的物品具有最大的价值总和？
 * 
 * 
 * @author hasee
 *
 */
class Package {

	private String name;

	private int weight;

	private int value;

	public Package(String name, int weight, int value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}
}

public class Solution {

	public static int bagWay(Package[] pg, int bagSize) {

		// 第一个参数表示从pg[0]开始依次放入的物品，
		// 第二个参数代表背包的承重,放弃第0列数组
		int[][] state = new int[pg.length][bagSize + 1];
		int newValue = 0;

		/**
		 * 01背包的状态转换方程 f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ), f[i-1,j] }
		 * f[i,j]：在前i件物品中选择若干件放在承重为 j 的背包中，可以取得的最大价值。 Pi表示第i件物品的价值。
		 * 决策：为了背包中物品总价值最大化，第 i件物品应该放入背包中吗 ？ 2. 以a8（行为a，列为的8的单元格） 举例 f[i,j] =
		 * a8= 15 f[i-1,j] = b8 = 9 f[i-1,j-Wi]
		 * 表示我有一个承重为6的背包（等于当前背包承重减去物品a的重量），当只有物品b,c,d,e四件可选时，这个背包能装入的最大价值
		 * f[i-1,j-Wi] +Pi =b(8 - 2) + 6 = b6 + 6 = 15
		 * 
		 */
		for (int i = 0; i < pg.length; i++) {
			// 背包的承重量
			for (int j = 1; j < state[i].length; j++) {
				if (i == 0) {
					if (pg[i].getWeight() <= j) {
						state[i][j] = pg[i].getValue();
					}
				} else {
					state[i][j] = state[i - 1][j];
					if (j < pg[i].getWeight()) {
						continue;
					}
					newValue = state[i - 1][j - pg[i].getWeight()] + pg[i].getValue();
					state[i][j] = Math.max(newValue, state[i - 1][j]);
				}
			}
		}
		for (int i = 0; i < state.length; i++) {
			System.out.println(Arrays.toString(state[i]));
		}
		return state[pg.length - 1][bagSize];
	}

	public static void main(String[] args) {
		Package[] pg = { new Package("e", 4, 6), new Package("d", 5, 4), new Package("c", 6, 5), new Package("b", 2, 3),
				new Package("a", 2, 6) };
		System.out.println(bagWay(pg, 10));
	}
}
