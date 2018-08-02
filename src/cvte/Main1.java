package cvte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {
	public int[] merge(int[] A, int[] B) {
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				list.add(B[j]);
				j++;
			} else {
				list.add(A[i]);
				i++;
			}
		}
		if (i == A.length) {
			for (int k = j; k < B.length; k++) {
				list.add(B[k]);
			}
		}
		if (j == B.length) {
			for (int k = i; k < A.length; k++) {
				list.add(A[k]);
			}
		}

		int[] result = new int[A.length + B.length];
		for (i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] A = { 98, 92, 90, 87 };
		int[] B = { 97, 93, 91, 88, 85 };
		int[] C = new Main1().merge(A, B);
		System.out.println(Arrays.toString(C));
	}
}
