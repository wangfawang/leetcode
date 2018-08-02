package min4revArr;

public class MySolution {
	public int minNumberInRotateArray(int[] array) {
		int size = array.length;
		if (size == 0) {
			return 0;
		}
		int left = 0;
		int right = size - 1;
		int mid = 0;
		while (array[left] <= array[right]) {
			if (right - left == 1) {
				mid = right;
				break;
			}
			mid = left + (right - left) / 2;
			if (array[mid] == array[left] && array[mid] == array[right])
				return seqSearchMin(array, left, right);
			if (array[mid] >= array[left])
				left = mid;
			else
				right = mid;
		}
		return array[mid];
	}

	private int seqSearchMin(int[] array, int left, int right) {
		int min = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
}
