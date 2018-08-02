package sort;

import java.util.Arrays;

/**
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，
 * 以达到整个序列有序。 算法描述
 * 
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * 
 * 
 * 
 * 1、先从数列中取出一个数作为基准数
 * 
 * 2、分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
 * 
 * 3、再对左右区间重复第二步，直到各区间只有一个数
 * 
 * 
 * @author hasee
 *
 */
public class Quick {
	public static void quickSort(int[] a, int left, int right) {
		if (left >= right || a.length <= 0) {// i大于或等于j，直接返回  
			return;
		}
		int i = left;// 左下标
		int j = right;// 右下标
		int key = a[left];// 将数组第一个作为基准数

		// 让数组中的全部元素都比较
		while (true) {
			// j往前走
			while (i < j) {
				if (a[j] < key) {// 找到第一个小于key的值A[j]，A[i]与A[j]交换
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					break;
				} else {
					j--;
				}
			}
			// i往后走
			while (i < j) {
				if (a[i] > key) { // 找到第一个大于key的A[i]，A[i]与A[j]交换
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					break;
				} else {
					i++;
				}
			}
			// 终结最外层while循环，表示一趟排序结束（全部元素都进行了比较）
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
