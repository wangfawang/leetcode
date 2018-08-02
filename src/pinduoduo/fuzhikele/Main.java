package pinduoduo.fuzhikele;

import java.util.Scanner;

/**
 * �Զ��ۻ������� N ƿ���ƿ��֡����ƿ��ַǳ����棬���������˻Ḵ�Ƴ�һ���Լ����� ������ Alice, Bob, Cathy, Dave
 * �ĸ������Ŷ����ƿ��֡�������˻����Ϻȵ���Ȼ���������ĸ���������ȥ�����������Ŷ�����֡� �����һ���򵽸��ƿ��ֵ��˽�ʲô���֣�
 * 
 * ��������:
 * 
 * �������һ�У�����һ�������� N (1 <= N <= 1,000,000,000)����ʾ���ֵ�������
 * 
 * �������:
 * 
 * ����ȵ����һ�޸��ƿ��ֵ��˵����֡�
 * 
 * ʾ��1 ���� ����
 * 
 * 8
 * 
 * ��� ����
 * 
 * Bob
 * 
 * ˵��
 * 
 * ǰ8���ȵ����ֵ�������Ϊ��Alice, Bob, Cathy, Dave, Alice, Alice, Bob, Bob.
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		int k = 0;
		for (k = 2; k <= 30; k++) {
			if ((Math.pow(2, k) - 4) < n && n <= (Math.pow(2, k + 1) - 4)) {
				break;
			}
		}
		double m = (n - (Math.pow(2, k) - 4)) / Math.pow(2, k);
		if (0 < m && m <= 0.25) {
			System.out.println("Alice");
		}
		if (0.25 < m && m <= 0.5) {
			System.out.println("Bob");
		}
		if (0.5 < m && m <= 0.75) {
			System.out.println("Cathy");
		}
		if (0.75 < m && m <= 1) {
			System.out.println("Dave");
		}
	}
}
