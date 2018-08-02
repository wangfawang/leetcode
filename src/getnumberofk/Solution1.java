package getnumberofk;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 
 * @author hasee
 *
 */
public class Solution1 {
	// 看见有序，肯定就是二分查找了
	// 折半查找，平均查找长度log2n
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

	// 循环写法
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

	// 递归写法
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
