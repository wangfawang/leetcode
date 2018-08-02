package getLeastNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * @author hasee
 *
 */
public class Solution {
	
	//利用选择排序，O(n^2)
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		List<Integer> list = new ArrayList<>();
		int minIndex;
		if (k > input.length)
			return (ArrayList<Integer>) list;
		for (int i = 0; i < k; i++) {
			minIndex = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < input[minIndex])
					minIndex = j;
			}
			swap(input, i, minIndex);
			list.add(input[i]);
		}
		return (ArrayList<Integer>) list;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(new Solution().GetLeastNumbers_Solution(input, 9));
	}
}
