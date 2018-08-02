package getLeastNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * 
 * @author hasee
 *
 */
public class Solution1 {

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(new Solution1().GetLeastNumbers_Solution(input, 4));
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {// �������ʾ��
		List<Integer> list = new ArrayList<>();
		if (input == null || input.length == 0 || input.length < k) {
			return (ArrayList<Integer>) list;
		}
		buildMinHeap(input);// ����С�Ѷ���input[0]����Сֵ
		// ���Ѷ�Ԫ�����ν���������ĩβ
		for (int i = input.length - 1; i > input.length - 1 - k; i--) {
			list.add(input[0]);
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			minify(input, 0, i);// ���¶��µĶѽ���С�Ѷ�
		}
		return (ArrayList<Integer>) list;

	}

	// ���������𲽽���С�Ѷ�
	private int[] buildMinHeap(int[] array) {
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			minify(array, i, array.length);
		}
		return array;
	}

	// ĳ�ڵ�����������С�Ѷ�
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
