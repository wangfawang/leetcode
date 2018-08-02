package getLeastNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String result = "";
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(",");
		int k = Integer.valueOf(str[str.length - 1]);
		int[] nums = new int[str.length - 1];
		for (int i = 0; i < str.length - 1; i++) {
			nums[i] = Integer.valueOf(str[i]);
		}
		for (int i = 0; i < k; i++) {
			result +=nums[i]+" ";
		}
		System.out.println(result.trim());
	}
}
