package printMatrix;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字， 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author hasee
 *
 */
public class Solution1 {
	ArrayList<Integer> al = new ArrayList<>();

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		int start = 0;
		while (true) {
			int row = matrix.length - 2 * start;
			int col = matrix[0].length - 2 * start;
			if (row <= 0 || col <= 0)
				break;
			printMatrixCircle(matrix, row, col, start);
			start++;
		}
		return al;
	}

	public void printMatrixCircle(int[][] matrix, int row, int col, int start) {
		for (int i = 0; i < col - 1; i++) {
			al.add(matrix[start][start + i]);
		}
		for (int i = 0; i < row - 1; i++) {
			al.add(matrix[start + i][col + start - 1]);
		}
		for (int i = 0; i < col - 1; i++) {
			al.add(matrix[start + row - 1][col + start - 1 - i]);
		}
		for (int i = 0; i < row - 1; i++) {
			al.add(matrix[start + row - 1 - i][start]);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 } };
		System.out.println(new Solution1().printMatrix(matrix).toString());
	}
}
