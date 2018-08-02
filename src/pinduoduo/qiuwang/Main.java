package pinduoduo.qiuwang;

import java.util.Scanner;

/**
 * 四年一度的世界杯又来了！小多在公司内发起了一个票选最强球星的活动。共有 N
 * 个候选球星，每位投票者需要在选票上为每位候选球星评定一个实例等级，等级由英文字母表示，'a' 级最高，'z' 级最低，共26级。 我们称候选球星 X
 * 强于候选球星 Y，当「 X 的评级比 Y 高」的票数高于「 Y 的评级比 X
 * 高」的票数。若一个候选球星强于任一其他候选球星时，则称该球星为“球王”。根据这个规则，至多只会有一个球王。需要注意的是也可能没有球王。 现在给出所有 M
 * 张选票，请你帮小多判断一下哪位候选球星是球王。 输入描述:
 * 
 * 第一行包含2个整数 N、M，分别表示候选球星数量以及选票数量。 接下来有 M 行，每行是一个长度为 N
 * 的字符串，每个字符串表示一张选票上的信息。每个字符串的第 k (0 <= k < N) 个字符，表示这张选票对第 k 个候选球星的评级。 数据范围： 1
 * <= N <= 50 1 <= M <= 50 字符串只包含小写英文字母(a-z)。
 * 
 * 输出描述:
 * 
 * 若有球王，则输出一行仅包含一个整数 X，表示编号为 X (0 <= X < N) 的候选球星是球王；若没有球王，则输出一行仅包含一个整数 -1 。
 * 
 * 示例1 输入 复制
 * 
 * 4 3 acbd bacd bdca
 * 
 * 输出 复制
 * 
 * 0
 * 
 * 示例2 输入 复制
 * 
 * 3 3 abc bca cab
 * 
 * 输出 复制
 * 
 * -1
 * 
 * 示例3 输入 复制
 * 
 * 4 1 abac
 * 
 * 输出 复制
 * 
 * -1
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] mn = sc.nextLine().split(" ");
		int N = Integer.valueOf(mn[0]);// 球员数
		int M = Integer.valueOf(mn[1]);// 票数
		char[][] ball = new char[M][N];
		for (int i = 0; i < M; i++) {
			ball[i] = sc.nextLine().toCharArray();
		}
		int j = 0;
		int count = 0;
		int result = 0;
		for (j = 0; j < N - 1; j++) {
			result = j;
			count = 0;
			for (int i = 0; i < M; i++) {
				if (ball[i][result] < ball[i][j + 1]) {
					count++;
				}
				if (ball[i][result] > ball[i][j + 1]) {
					count--;
				}
				if (count > 0) {
					result = j;
				} else if (count < 0) {
					result = j + 1;
				} else {
					result = -1;
				}
			}
		}
		System.out.println(result);
	}
}
