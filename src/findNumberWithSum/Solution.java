package findNumberWithSum;

import java.util.ArrayList;

/**
 * 
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 输出描述:
 * 
 * 对应每个测试案例，输出两个数，小的先输出。
 * 
 * 
 * @author hasee
 *
 */

/*
 * 数列满足递增，设两个头尾两个指针i和j， 若ai + aj == sum，就是答案（相差越远乘积越小） 若ai + aj
 * >sum，和太大了，需要降低数值，则j -= 1 若ai + aj < sum，和太小了，需要提高数值，i += 1 O(n)
 */
public class Solution {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		int len = array.length;
		int i = 0;
		int j = len - 1;
		while (i < j) {
			if (array[i] + array[j] == sum) {
				list.add(array[i]);
				list.add(array[j]);
				break;
			} else if (array[i] + array[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
		return list;
	}
}
