package hasPath;

/**
 * ��һ��״̬���鱣��֮ǰ���ʹ����ַ���Ȼ���ٷֱ��ϣ��£����ҵݹ�
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

	// �ݹ�dfs
	private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
		int index = i * cols + j;
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
			return false;
		// matrix[index] == str[k]�����flag�Ѿ����ʹ�
		flag[index] = 1;
		// ���k==str.length-1����˵���Ѿ��ҵ�·����
		if (k == str.length - 1)
			return true;
		// ��������������κ�һ����������һ���ڵ㣬����true
		if (helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
				|| helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
				|| helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)
				|| helper(matrix, rows, cols, i, j - 1, str, k + 1, flag))
			return true;

		// ������ϵĶ�û�����㣬����Ҫ���ݣ�������һ���ڵ�λ�ã����ýڵ���������Ϊδ����
		flag[index] = 0;
		return false;
	}
}
