package fibonacci;

/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
 * 
 * n<=39
 * 
 * @author hasee
 *
 */
public class Solution {
	
	//�õݹ�Ч��̫�ͣ����һ����ջ���������Ӧ��ʹ�õ���
	public int Fibonacci(int n) {
		if (n <= 1)
			return n;

		int[] result = new int[n + 1];
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i <= n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().Fibonacci(10000));
	}
}
