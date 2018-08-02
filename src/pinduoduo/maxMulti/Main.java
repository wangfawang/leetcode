package pinduoduo.maxMulti;

import java.util.Scanner;

/**
 * ����һ���������飬����������������0��Ҫ������ҳ�3�����ĳ˻���ʹ�ó˻����Ҫ��ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(1) ��������:
 * ������������A[n]
 * 
 * �������: �������������˻�
 * 
 * ��������1: 3 4 1 2
 * 
 * �������1:
 * 
 * 24
 * 
 * ���˻�Ϊ�����������ֳ˻��������һ�����ֺ���С�������ֳ˻�������������
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		long max1 = Long.MIN_VALUE;
		long max2 = Long.MIN_VALUE;
		long max3 = Long.MIN_VALUE;
		long min1 = Long.MAX_VALUE;
		long min2 = Long.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (arr[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2) {
				max3 = max2;
				max2 = arr[i];
			} else if (arr[i] > max3) {
				max3 = arr[i];
			}
			if (arr[i] < min1) {
				min2 = min1;
				min1 = arr[i];
			} else if (arr[i] < min2) {
				min2 = arr[i];
			}
		}

		System.out.println(Math.max(max1 * max2 * max3, min1 * min2 * max1));
	}
}
