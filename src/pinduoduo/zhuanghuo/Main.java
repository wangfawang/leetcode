package pinduoduo.zhuanghuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有N个货物（0<=N<=1024），每个货物的重量是W（100<=W<=300）。如果每辆车最多的载重为300，请问最少需要多少辆车才能运输所有货物。
 * 
 * 输入描述:
 * 
 * 一行输入，包含N个正整数，表示每个货物的重量，空格分隔。
 * 
 * 输出描述:
 * 
 * 一行输出，包含一个整数，表示需要的车辆数。
 * 
 * 示例1 输入 复制
 * 
 * 130 140 150 160 190 280
 * 
 * 输出 复制
 * 
 * 2
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			int[] weight = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				weight[i] = Integer.valueOf(str[i]);
			}
			Arrays.sort(weight);
			int size = 300;
			int carNum = 0;
			int left = 0, right = weight.length - 1;
			while (left <= right) {

				if ((size = size - weight[right]) >= 0) {
					right--;
					while ((size = size - weight[left]) >= 0 && (left <= right)) {
						left++;
					}
					carNum++;
					size = 300;

				}

			}
			System.out.println(carNum);
		}
	}
}
