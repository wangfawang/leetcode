package getnumberofk;

/**
 * ͳ��һ�����������������г��ֵĴ�����
 * 
 * @author hasee
 *
 */
public class Solution1 {
	// �������򣬿϶����Ƕ��ֲ�����
	// �۰���ң�ƽ�����ҳ���log2n
	public int GetNumberOfK(int[] array, int k) {
		int length = array.length;
		if (length == 0)
			return 0;

		int firstK = getFirstK(array, 0, length - 1, k);
		int lastK = getLastK(array, 0, length - 1, k);

		if (firstK != -1 && lastK != -1) {
			return lastK - firstK + 1;
		}
		return 0;
	}

	// ѭ��д��
	private int getLastK(int[] array, int low, int high, int k) {
		int len = array.length;
		int mid;
		while (low <= high) {
			mid = (low + high) >> 1;
			if (array[mid] < k)
				low = mid + 1;
			else if (array[mid] > k)
				high = mid - 1;
			else if (mid + 1 < len && array[mid + 1] == k)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	// �ݹ�д��
	private int getFirstK(int[] array, int low, int high, int k) {
		if (low > high)
			return -1;
		int mid = (low + high) >> 1;
		if (array[mid] < k)
			return getFirstK(array, mid + 1, high, k);
		else if (array[mid] > k)
			return getFirstK(array, low, mid - 1, k);
		else if (mid - 1 >= 0 && array[mid - 1] == k)
			return getFirstK(array, low, mid - 1, k);
		else
			return mid;
	}
}
