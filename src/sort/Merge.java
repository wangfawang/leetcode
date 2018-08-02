package sort;

/**
 * �鲢�����ǽ����ڹ鲢�����ϵ�һ����Ч�������㷨�����㷨�ǲ��÷��η���Divide and
 * Conquer����һ���ǳ����͵�Ӧ�á���������������кϲ����õ���ȫ��������У�����ʹÿ��������������ʹ�����жμ������������������ϲ���һ�������
 * ��Ϊ2-·�鲢�� �㷨����:
 * 
 * �ѳ���Ϊn���������зֳ���������Ϊn/2�������У� �������������зֱ���ù鲢���� ����������õ������кϲ���һ�����յ��������С�
 * 
 * @author hasee
 *
 */
public class Merge {
	// first�����ʼ����ֵ��mid����ֽ��������last�������������temp[]��ʱ����
	// ��midΪ���ޣ���a��Ϊ�������飬������й鲢����
	// �������������кϲ�������ǳ��򵥣�ֻҪ�ӱȽ϶������еĵ�һ������
	// ˭С����ȡ˭��ȡ�˺���ڶ�Ӧ������ȡ��һ������Ȼ���ٽ��бȽϣ�
	// ��������б�����ϣ���ֱ�ӽ���һ�����е���������ȡ�����ɡ�
	void mergearray(int a[], int first, int mid, int last, int temp[]) {// ������������Ĺ鲢
		int i = first, m = mid;// ��һ������ķ�Χ
		int j = mid + 1, n = last;// �ڶ�������ķ�Χ
		int k = 0;// temp�ĳ�ʼ�±�

		while (i <= m && j <= n) {// �ֱ������������ȡֵ

			if (a[i] <= a[j])// ȡ��С�����ŵ�temp������
				temp[k++] = a[i++];// �Ƚ��и�ֵ���㣬Ȼ��k��i�Լ�1
			// ע�⣬����j��û�б仯����һ�αȽ���Ȼ����һ�ε�jֵ��ֱ��else����
			else
				temp[k++] = a[j++];// j�仯��i���仯
		}
		// �������������Ԫ�أ�ֱ�Ӹ��Ƶ�temp���漴��
		while (i <= m)
			temp[k++] = a[i++];
		while (j <= n)
			temp[k++] = a[j++];
		// ���ź�����������¸���a
		for (i = 0; i < k; i++) {
			a[first + i] = temp[i];
		}

	}

	void mergesort(int a[], int first, int last, int temp[])
	// a[]����Ҫ��������飬first, last��������Χ
	{
		if (first < last) {// ��������ֻ��һ��Ԫ��ʱ��first==last���ݹ����

			int mid = (first + last) / 2;
			mergesort(a, first, mid, temp);// ��ߵݹ飬ֱ��ֻʣһ��Ԫ��
			mergesort(a, mid + 1, last, temp);// �ұߵݹ飬ֱ��ֻʣһ��Ԫ��
			mergearray(a, first, mid, last, temp); // �ٽ������������кϲ�
		}
	}

	public void sort(int[] a) {
		int n = a.length;
		int[] temp = new int[n];
		mergesort(a, 0, n - 1, temp);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 5, 8, 4, 14 };
		ArrayUtil.printArray(arr);
		new Merge().sort(arr);
		ArrayUtil.printArray(arr);
	}
}
