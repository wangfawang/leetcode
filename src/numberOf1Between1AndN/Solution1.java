package numberOf1Between1AndN;

/**
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��
 * 13��˹�����6��,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�����
 * 
 * @author hasee
 *
 */
public class Solution1 {
	// �����ⷨ
	public int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			sb.append(i);
		}
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '1')
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution1().NumberOf1Between1AndN_Solution(10000));
	}
}
