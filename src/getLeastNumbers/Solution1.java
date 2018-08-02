package getLeastNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * @author hasee
 *
 */
public class Solution1 {

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(new Solution1().GetLeastNumbers_Solution(input, 4));
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {// 用数组表示堆
		List<Integer> list = new ArrayList<>();
		if (input == null || input.length == 0 || input.length < k) {
			return (ArrayList<Integer>) list;
		}
		buildMinHeap(input);// 建立小堆顶，input[0]是最小值
		// 将堆顶元素依次交换至数组末尾
		for (int i = input.length - 1; i > input.length - 1 - k; i--) {
			list.add(input[0]);
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			minify(input, 0, i);// 重新对新的堆建立小堆顶
		}
		return (ArrayList<Integer>) list;

	}

	// 从下至上逐步建立小堆顶
	private int[] buildMinHeap(int[] array) {
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			minify(array, i, array.length);
		}
		return array;
	}

	// 某节点子树建立成小堆顶
	private void minify(int[] array, int k, int size) {
		int temp = array[k];
		for (int i = 2 * k + 1; i < size; i = 2 * i + 1) {
			if (i + 1 < size && array[i] > array[i + 1]) {
				i++;
			}
			if (temp <= array[i]) {
				break;
			} else {
				array[k] = array[i];
				k = i;
			}
		}
		array[k] = temp;
	}
}
