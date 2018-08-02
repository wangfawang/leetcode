package printMatrix;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字， 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author hasee
 *
 */
public class Solution {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> al = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0)
			return al;
		int top = 0, left = 0, right = col - 1, bottom = row - 1;
		while (top <= bottom && left <= right) {
			// 从左到右
			for (int i = left; i <= right; ++i)
				al.add(matrix[top][i]);
			// 从上到下
			for (int i = top + 1; i <= bottom; ++i)
				al.add(matrix[i][right]);
			// 从右到左
			for (int i = right - 1; i >= left && top < bottom; --i)
				al.add(matrix[bottom][i]);
			// 从下倒上
			for (int i = bottom - 1; i >= top + 1 && left < right; --i)
				al.add(matrix[i][left]);
			++top;
			++left;
			--right;
			--bottom;
		}
		return al;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		System.out.println(new Solution().printMatrix(matrix).toString());
	}
}
