package multiply;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A
 * [i+1]*...*A[n-1]。不能使用除法。
 * 
 * @author hasee
 *
 */
public class Solution {
	public int[] multiply(int[] A) {
		int[] B = new int[A.length];
		for (int j = 0; j < B.length; j++) {
			B[j] = 1;
			for (int i = 0; i < A.length; i++) {
				if (i == j)
					continue;
				B[j] *= A[i];
			}
		}
		return B;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		System.out.println(Arrays.toString((new Solution().multiply(A))));
	}
}
