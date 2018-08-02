package sort;

import java.util.Arrays;

public class MinHeap {
	public void minHeapSort(int[] input) {// 用数组表示堆
		buildMinHeap(input);// 首先建立一个小堆顶,此时input[0]最小
		for (int i = input.length - 1; i >= 1; i--) {// 执行len次，每次将最小值放到堆末尾
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			minify(input, 0, i);
		}

	}

	public void buildMinHeap(int[] arr) {
		for (int i = (arr.length - 2) / 2; i >= 0; i--) {
			minify(arr, i, arr.length);// 从末尾节点的父节点开始依次建立小根堆
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
