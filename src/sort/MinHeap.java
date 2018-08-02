package sort;

import java.util.Arrays;

public class MinHeap {
	public void minHeapSort(int[] input) {// �������ʾ��
		buildMinHeap(input);// ���Ƚ���һ��С�Ѷ�,��ʱinput[0]��С
		for (int i = input.length - 1; i >= 1; i--) {// ִ��len�Σ�ÿ�ν���Сֵ�ŵ���ĩβ
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			minify(input, 0, i);
		}

	}

	public void buildMinHeap(int[] arr) {
		for (int i = (arr.length - 2) / 2; i >= 0; i--) {
			minify(arr, i, arr.length);// ��ĩβ�ڵ�ĸ��ڵ㿪ʼ���ν���С����
		}
	}

	public void minify(int[] arr, int k, int size) {
		int temp = arr[k];
		for (int i = 2 * k + 1; i < size; i++) {
			if (i + 1 < size && arr[i] > arr[i + 1]) {
				i++;
			}
			if (temp <= arr[i]) {
				break;
			} else {
				arr[k] = arr[i];
				k = i;
			}
		}
		arr[k] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		new MinHeap().minHeapSort(input);
		System.out.println(Arrays.toString(input));
	}
}
