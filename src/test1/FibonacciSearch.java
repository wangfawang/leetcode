package test1;

import java.util.Arrays;

public class FibonacciSearch {
	/** 쳲��������� */
	static int[] f = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };

	/**
	 * 쳲���������(�ƽ�ָ�ԭ��)
	 * 
	 * @param a
	 *            ����ѯ����
	 * @param key
	 *            �����ҹؼ���
	 * @return ���عؼ�����a�����е��±꣬����-1��ʾ�����в����ڴ˹ؼ���
	 */
	public static int fibonaciSearch(int[] a, int key) {
		int low, mid, high, k;
		low = 0;
		high = a.length - 1;
		// 쳲����������±�
		k = 0;
		// ��ȡ쳲������ָ�ֵ�±�
		while (high > f[k] - 1)
			k++;
		 // ����Java������Arrays���쳤��Ϊf[k]�������鲢ָ������a
		 a = Arrays.copyOf(a, f[k]);
		 // ���������������Ԫ�ظ�ֵ����Ԫ��
		 for (int i = high + 1; i < f[k]; i++) {
		 a[i] = a[high];// ��key�������ֵʱ�򣬷�ֹ�Ǳ�Խ���쳣
		 }
		while (low <= high) {
			// ǰ�벿����f[k-1]��Ԫ�أ������±��0��ʼ
			// ��ȥ 1 ��ȡ �ָ�λ��Ԫ�ص��±�
			mid = low + f[k - 1] - 1;

			if (key < a[mid]) {// �ؼ���С�ڷָ�λ��Ԫ�أ����������ǰ�벿�֣���λָ���ƶ�
				high = mid - 1;
				// (ȫ��Ԫ��) = (ǰ�벿��)+(��벿��)
				// f[k] = f[k-1] + f[k-2]
				// ��Ϊǰ�벿����f[k-1]��Ԫ�أ� ��������f[k-1] = f[k-2] + f[k-3]����
				// ����f[k-1]��Ԫ�ص�ǰ�벿��f[k-2]�м������ң�����k = k - 1,
				// ���´�ѭ��mid = low + f[k - 1 - 1] - 1;
				k = k - 1;
			} else if (key > a[mid]) {// �ؼ��ִ��ڷָ�λ��Ԫ�أ�����Һ�벿�֣���λָ���ƶ�
				low = mid + 1;
				// (ȫ��Ԫ��) = (ǰ�벿��)+(��벿��)
				// f[k] = f[k-1] + f[k-2]
				// ��Ϊ��벿����f[k-2]��Ԫ�أ� ��������f[k-2] = f[k-3] + f[k-4]����
				// ����f[k-2]��Ԫ�ص�ǰ�벿��f[k-3]�������ң�����k = k - 2,
				// ���´�ѭ��mid = low + f[k - 2 - 1] - 1;
				k = k - 2;
			} else {
				// ������������ʱ�����ҵ�Ԫ��
				if (mid <= high)
					return mid;
				else
					// ������������ǲ��ҵ������Ԫ��
					// �������Ԫ����highλ�õ�Ԫ��һ��
					return high;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		int index = fibonaciSearch(a, 14);
		System.out.println(index);
	}
}
