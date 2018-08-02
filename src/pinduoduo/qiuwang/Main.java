package pinduoduo.qiuwang;

import java.util.Scanner;

/**
 * ����һ�ȵ����籭�����ˣ�С���ڹ�˾�ڷ�����һ��Ʊѡ��ǿ���ǵĻ������ N
 * ����ѡ���ǣ�ÿλͶƱ����Ҫ��ѡƱ��Ϊÿλ��ѡ��������һ��ʵ���ȼ����ȼ���Ӣ����ĸ��ʾ��'a' ����ߣ�'z' ����ͣ���26���� ���ǳƺ�ѡ���� X
 * ǿ�ں�ѡ���� Y������ X �������� Y �ߡ���Ʊ�����ڡ� Y �������� X
 * �ߡ���Ʊ������һ����ѡ����ǿ����һ������ѡ����ʱ����Ƹ�����Ϊ�������������������������ֻ����һ����������Ҫע�����Ҳ����û�������� ���ڸ������� M
 * ��ѡƱ�������С���ж�һ����λ��ѡ������������ ��������:
 * 
 * ��һ�а���2������ N��M���ֱ��ʾ��ѡ���������Լ�ѡƱ������ �������� M �У�ÿ����һ������Ϊ N
 * ���ַ�����ÿ���ַ�����ʾһ��ѡƱ�ϵ���Ϣ��ÿ���ַ����ĵ� k (0 <= k < N) ���ַ�����ʾ����ѡƱ�Ե� k ����ѡ���ǵ������� ���ݷ�Χ�� 1
 * <= N <= 50 1 <= M <= 50 �ַ���ֻ����СдӢ����ĸ(a-z)��
 * 
 * �������:
 * 
 * ���������������һ�н�����һ������ X����ʾ���Ϊ X (0 <= X < N) �ĺ�ѡ��������������û�������������һ�н�����һ������ -1 ��
 * 
 * ʾ��1 ���� ����
 * 
 * 4 3 acbd bacd bdca
 * 
 * ��� ����
 * 
 * 0
 * 
 * ʾ��2 ���� ����
 * 
 * 3 3 abc bca cab
 * 
 * ��� ����
 * 
 * -1
 * 
 * ʾ��3 ���� ����
 * 
 * 4 1 abac
 * 
 * ��� ����
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
		int N = Integer.valueOf(mn[0]);// ��Ա��
		int M = Integer.valueOf(mn[1]);// Ʊ��
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
