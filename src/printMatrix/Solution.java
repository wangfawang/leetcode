package printMatrix;

import java.util.ArrayList;

/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣� ���磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
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
			// ������
			for (int i = left; i <= right; ++i)
				al.add(matrix[top][i]);
			// ���ϵ���
			for (int i = top + 1; i <= bottom; ++i)
				al.add(matrix[i][right]);
			// ���ҵ���
			for (int i = right - 1; i >= left && top < bottom; --i)
				al.add(matrix[bottom][i]);
			// ���µ���
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
