package pinduoduo.giveqiaokeli;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i]
 * (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]>
 * 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 * 
 * 输入描述: 第一行：n，表示h数组元素个数 第二行：n个h数组元素 第三行：m，表示w数组元素个数 第四行：m个w数组元素
 * 
 * 输出描述: 上台表演学生人数
 * 
 * 输入例子1:
 * 
 * 3 2 2 3 2 3 1
 * 
 * 输出例子1: 1
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int childNum = sc.nextInt();
		int[] child = new int[childNum];
		for (int i = 0; i < childNum; i++) {
			child[i] = sc.nextInt();
		}
		int choNum = sc.nextInt();
		int[] cho = new int[choNum];
		for (int i = 0; i < choNum; i++) {
			cho[i] = sc.nextInt();
		}
		System.out.println(giveCho(cho, child));

	}

	public static int giveCho(int[] cho, int[] child) {
		int count = 0;
		Arrays.sort(cho);
		Arrays.sort(child);
		// 开始分发巧克力，用贪心算法，从最小的开始发起
		for (int i = 0, j = 0; i < cho.length && j < child.length; i++) {
			if (cho[i] >= child[j]) {
				count++;
				j++;
			}
		}
		return count;
	}
}
