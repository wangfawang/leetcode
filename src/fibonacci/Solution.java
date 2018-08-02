package fibonacci;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * 
 * n<=39
 * 
 * @author hasee
 *
 */
public class Solution {
	
	//用递归效率太低，并且会出现栈溢出，这里应该使用迭代
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
