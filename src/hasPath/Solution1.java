package hasPath;

/**
 * 用一个状态数组保存之前访问过的字符，然后再分别按上，下，左，右递归
 */
public class Solution1 {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		int[] flag = new int[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (helper(matrix, rows, cols, i, j, str, 0, flag))
					return true;
			}
		}
		return false;
	}

	// 递归dfs
	private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
		int index = i * cols + j;
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
			return false;
		// matrix[index] == str[k]，标记flag已经访问过
		flag[index] = 1;
		// 如果k==str.length-1，则说明已经找到路径了
		if (k == str.length - 1)
			return true;
		// 如果上下左右有任何一个能满足下一个节点，返回true
		if (helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
				|| helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
				|| helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)
				|| helper(matrix, rows, cols, i, j - 1, str, k + 1, flag))
			return true;

		// 如果以上的都没有满足，则需要回溯，返回上一个节点位置，将该节点重新设置为未访问
		flag[index] = 0;
		return false;
	}
}
