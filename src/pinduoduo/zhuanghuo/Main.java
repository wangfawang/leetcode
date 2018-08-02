package pinduoduo.zhuanghuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��N�����0<=N<=1024����ÿ�������������W��100<=W<=300�������ÿ������������Ϊ300������������Ҫ�������������������л��
 * 
 * ��������:
 * 
 * һ�����룬����N������������ʾÿ��������������ո�ָ���
 * 
 * �������:
 * 
 * һ�����������һ����������ʾ��Ҫ�ĳ�������
 * 
 * ʾ��1 ���� ����
 * 
 * 130 140 150 160 190 280
 * 
 * ��� ����
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
