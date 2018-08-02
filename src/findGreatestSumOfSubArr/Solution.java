package findGreatestSumOfSubArr;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2
 * ,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 * 
 * @author hasee
 *
 */
/*
 * 算法时间复杂度O（n） 用total记录累计值，maxSum记录和最大
 * 基于思想：对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值对
 * 整体和是有贡献的。如果前几项累计值负数，则认为有害于总和，total记录当前值。 此时 若和大于maxSum 则用maxSum记录下来
 */
public class Solution {
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 0 || array == null)
			return 0;
		int total = array[0];
		int maxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (total >= 0)
				total += array[i];
			else
				total = array[i];
			if (total > maxSum)
				maxSum = total;
		}
		return maxSum;

	}

	public static void main(String[] args) {
		int[] arr = { -1, -2, -3, -10, -4, -7, -2, -5 };
		System.out.println(new Solution().FindGreatestSumOfSubArray(arr));

	}
}
