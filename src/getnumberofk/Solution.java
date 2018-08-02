package getnumberofk;

/**
 * 统计一个数字在排序数组中出现的次数
 * 
 * @author hasee
 *
 */
public class Solution {
	//顺序查找，但是效率低，平均查找长度n
	public int GetNumberOfK(int[] array, int k) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == k)
				count++;
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,1,2,4,6};
		System.out.println(new Solution().GetNumberOfK(arr, 3));
	}
}
