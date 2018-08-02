package sort;

/**
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and
 * Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，
 * 称为2-路归并。 算法描述:
 * 
 * 把长度为n的输入序列分成两个长度为n/2的子序列； 对这两个子序列分别采用归并排序； 将两个排序好的子序列合并成一个最终的排序序列。
 * 
 * @author hasee
 *
 */
public class Merge {
	// first数组初始索引值，mid数组分界点索引，last数组结束索引，temp[]临时数组
	// 以mid为界限，将a分为两个数组，对其进行归并排序
	// 将二个有序数列合并。这个非常简单，只要从比较二个数列的第一个数，
	// 谁小就先取谁，取了后就在对应数列中取下一个数。然后再进行比较，
	// 如果有数列遍历完毕，那直接将另一个数列的数据依次取出即可。
	void mergearray(int a[], int first, int mid, int last, int temp[]) {// 两个有序数组的归并
		int i = first, m = mid;// 第一个数组的范围
		int j = mid + 1, n = last;// 第二个数组的范围
		int k = 0;// temp的初始下标

		while (i <= m && j <= n) {// 分别从两个数组中取值

			if (a[i] <= a[j])// 取较小的数放到temp数组中
				temp[k++] = a[i++];// 先进行赋值运算，然后k，i自加1
			// 注意，这里j并没有变化，下一次比较仍然是上一次的j值，直到else发生
			else
				temp[k++] = a[j++];// j变化，i不变化
		}
		// 如果数组中仍有元素，直接复制到temp后面即可
		while (i <= m)
			temp[k++] = a[i++];
		while (j <= n)
			temp[k++] = a[j++];
		// 将排好序的数组重新赋给a
		for (i = 0; i < k; i++) {
			a[first + i] = temp[i];
		}

	}

	void mergesort(int a[], int first, int last, int temp[])
	// a[]是需要排序的数组，first, last是索引范围
	{
		if (first < last) {// 当数组中只有一个元素时，first==last，递归结束

			int mid = (first + last) / 2;
			mergesort(a, first, mid, temp);// 左边递归，直到只剩一个元素
			mergesort(a, mid + 1, last, temp);// 右边递归，直到只剩一个元素
			mergearray(a, first, mid, last, temp); // 再将二个有序数列合并
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
