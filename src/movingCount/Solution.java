package movingCount;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 =
 * 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author hasee
 *
 */
public class Solution {

	// 该机器人能够达到多少个格子
	public int movingCount(int threshold, int rows, int cols) {
		int[][] flag = new int[rows][cols];// 用来标记是否访问过
		return helper(0, 0, rows, cols, threshold, flag);
	}

	// dfs思想，即访问点满足后递归再访问它的相邻点。这里没有使用到回溯，因为访问不了就不用管了，count不加+1就行。
	public int helper(int i, int j, int rows, int cols, int threshold, int[][] flag) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
			return 0;
		// 如果不满足上述条件，则说明可以到达该格子
		flag[i][j] = 1;// 标记为已到达

		// 递归调用该格子的相邻格子，并检测能否到达
		return helper(i - 1, j, rows, cols, threshold, flag) + helper(i + 1, j, rows, cols, threshold, flag)
				+ helper(i, j - 1, rows, cols, threshold, flag) + helper(i, j + 1, rows, cols, threshold, flag) + 1;

	}

	public int numSum(int num) {
		int result = 0;
		do {
			result += num % 10;
		} while ((num = num / 10) > 0);
		return result;
	}
}
