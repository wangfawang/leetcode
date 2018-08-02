package numberof1;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * @author hasee
 *
 */
public class Solution {
	public int NumberOf1_CanNotUse(int n) {
		int count = 0;

		/*
		 * 用1和n进行位与运算， 结果要是为1则n的2进制形式 最右边那位肯定是1，否则为0
		 */
		if ((n & 1) == 1) {
			count++;
		}
		// 把n的2进制形式往右推一位
		n = n >>> 1;

		return count;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(10));
		System.out.println(new Solution().NumberOf1_CanNotUse(10));
	}
}
