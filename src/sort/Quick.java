package sort;

import java.util.Arrays;

/**
 * ��������Ļ���˼�룺ͨ��һ�����򽫴��ż�¼�ָ��ɶ����������֣�����һ���ּ�¼�Ĺؼ��־�����һ���ֵĹؼ���С����ɷֱ���������ּ�¼������������
 * �Դﵽ������������ �㷨����
 * 
 * ��������ʹ�÷��η�����һ������list����Ϊ�����Ӵ���sub-lists���������㷨�������£�
 * 
 * 
 * 
 * 1���ȴ�������ȡ��һ������Ϊ��׼��
 * 
 * 2���������̣���������������ȫ�ŵ������ұߣ�С�ڻ����������ȫ�ŵ��������
 * 
 * 3���ٶ����������ظ��ڶ�����ֱ��������ֻ��һ����
 * 
 * 
 * @author hasee
 *
 */
public class Quick {
	public static void quickSort(int[] a, int left, int right) {
		if (left >= right || a.length <= 0) {// i���ڻ����j��ֱ�ӷ���  
			return;
		}
		int i = left;// ���±�
		int j = right;// ���±�
		int key = a[left];// �������һ����Ϊ��׼��

		// �������е�ȫ��Ԫ�ض��Ƚ�
		while (true) {
			// j��ǰ��
			while (i < j) {
				if (a[j] < key) {// �ҵ���һ��С��key��ֵA[j]��A[i]��A[j]����
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					break;
				} else {
					j--;
				}
			}
			// i������
			while (i < j) {
				if (a[i] > key) { // �ҵ���һ������key��A[i]��A[i]��A[j]����
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					break;
				} else {
					i++;
				}
			}
			// �ս������whileѭ������ʾһ�����������ȫ��Ԫ�ض������˱Ƚϣ�
			if (i == j)
				break;
		}

		quickSort(a, left, i - 1);
		quickSort(a, i + 1, right);

	}

	public static void quickSort(int[] a) {
		if (a.length > 0) {
			quickSort(a, 0, a.length - 1);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5, 7, 4, 5, 3, 9, 0 };
		System.out.println(Arrays.toString(a));
		quickSort(a);
		System.out.println(Arrays.toString(a));
	}
}
