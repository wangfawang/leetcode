package sort;

/**
 * 简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。 算法描述
 * 
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1； 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1
 * 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * 
 * @author hasee
 *
 */
public class Shell {
	public int[] shellSort(int[] arr) {
		int len = arr.length;
		int temp;
		int gap = 1;
		int preIndex;
		while (gap < len / 3) {// 动态定义间隔序列,这是一个算法
			gap = gap * 3 + 1;
		}
		while (gap >= 1) {// 某个增量的循环,i代表gap
			for (int i = gap; i < len; i++) {// j代表最远端的值
				preIndex = i - gap;
				temp = arr[i];
				while (preIndex >= 0 && arr[preIndex] > temp) {
					arr[preIndex + gap] = arr[preIndex];
					preIndex = preIndex - gap;
				}
				arr[preIndex + gap] = temp;
			}
			ArrayUtil.printArray(arr);
			gap = (gap - 1) / 3;
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 4,3,6,5 };
		ArrayUtil.printArray(arr);
		int[] res = new Shell().shellSort(arr);
		ArrayUtil.printArray(res);
	}
}
