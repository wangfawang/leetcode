package numberof1;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * 
 * @author hasee
 *
 */
public class Solution {
	public int NumberOf1_CanNotUse(int n) {
		int count = 0;

		/*
		 * ��1��n����λ�����㣬 ���Ҫ��Ϊ1��n��2������ʽ ���ұ���λ�϶���1������Ϊ0
		 */
		if ((n & 1) == 1) {
			count++;
		}
		// ��n��2������ʽ������һλ
		n = n >>> 1;

		return count;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(10));
		System.out.println(new Solution().NumberOf1_CanNotUse(10));
	}
}
