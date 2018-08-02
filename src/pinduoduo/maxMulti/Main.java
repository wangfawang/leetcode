package pinduoduo.maxMulti;

import java.util.Scanner;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1) 输入描述:
 * 无序整数数组A[n]
 * 
 * 输出描述: 满足条件的最大乘积
 * 
 * 输入例子1: 3 4 1 2
 * 
 * 输出例子1:
 * 
 * 24
 * 
 * 最大乘积为最大的三个数字乘积或者最大一个数字和最小两个数字乘积，负负得正。
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		long max1 = Long.MIN_VALUE;
		long max2 = Long.MIN_VALUE;
		long max3 = Long.MIN_VALUE;
		long min1 = Long.MAX_VALUE;
		long min2 = Long.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (arr[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2) {
				max3 = max2;
				max2 = arr[i];
			} else if (arr[i] > max3) {
				max3 = arr[i];
			}
			if (arr[i] < min1) {
				min2 = min1;
				min1 = arr[i];
			} else if (arr[i] < min2) {
				min2 = arr[i];
			}
		}

		System.out.println(Math.max(max1 * max2 * max3, min1 * min2 * max1));
	}
}
