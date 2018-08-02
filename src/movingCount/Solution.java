package movingCount;

/**
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 =
 * 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * 
 * @author hasee
 *
 */
public class Solution {

	// �û������ܹ��ﵽ���ٸ�����
	public int movingCount(int threshold, int rows, int cols) {
		int[][] flag = new int[rows][cols];// ��������Ƿ���ʹ�
		return helper(0, 0, rows, cols, threshold, flag);
	}

	// dfs˼�룬�����ʵ������ݹ��ٷ����������ڵ㡣����û��ʹ�õ����ݣ���Ϊ���ʲ��˾Ͳ��ù��ˣ�count����+1���С�
	public int helper(int i, int j, int rows, int cols, int threshold, int[][] flag) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
			return 0;
		// ���������������������˵�����Ե���ø���
		flag[i][j] = 1;// ���Ϊ�ѵ���

		// �ݹ���øø��ӵ����ڸ��ӣ�������ܷ񵽴�
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
