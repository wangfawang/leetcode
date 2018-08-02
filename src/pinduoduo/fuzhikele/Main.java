package pinduoduo.fuzhikele;

import java.util.Scanner;

/**
 * 自动售货机里有 N 瓶复制可乐。复制可乐非常神奇，喝了它的人会复制出一个自己来！ 现在有 Alice, Bob, Cathy, Dave
 * 四个人在排队买复制可乐。买完的人会马上喝掉，然后他和他的副本会重新去队伍的最后面排队买可乐。 问最后一个买到复制可乐的人叫什么名字？
 * 
 * 输入描述:
 * 
 * 输入仅有一行，包含一个正整数 N (1 <= N <= 1,000,000,000)，表示可乐的数量。
 * 
 * 输出描述:
 * 
 * 输出喝到最后一罐复制可乐的人的名字。
 * 
 * 示例1 输入 复制
 * 
 * 8
 * 
 * 输出 复制
 * 
 * Bob
 * 
 * 说明
 * 
 * 前8个喝到可乐的人依次为：Alice, Bob, Cathy, Dave, Alice, Alice, Bob, Bob.
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		int k = 0;
		for (k = 2; k <= 30; k++) {
			if ((Math.pow(2, k) - 4) < n && n <= (Math.pow(2, k + 1) - 4)) {
				break;
			}
		}
		double m = (n - (Math.pow(2, k) - 4)) / Math.pow(2, k);
		if (0 < m && m <= 0.25) {
			System.out.println("Alice");
		}
		if (0.25 < m && m <= 0.5) {
			System.out.println("Bob");
		}
		if (0.5 < m && m <= 0.75) {
			System.out.println("Cathy");
		}
		if (0.75 < m && m <= 1) {
			System.out.println("Dave");
		}
	}
}
