package pinduoduo.giveqiaokeli;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��һ��ͯ�ڣ���ʦ���˺ܶ�óԵ��ɿ������׶�԰��ÿ���ɿ���j������Ϊw[j]������ÿ��С����i�������ֵ����ɿ�����С�ﵽh[i]
 * (��w[j]>=h[i])�����Ż���ȥ���ݽ�Ŀ����ʦ��Ŀ���ǽ��ɿ����ַ��������ǣ�ʹ������С����̨���ݡ����Ա�֤ÿ��w[i]>
 * 0�Ҳ��ܽ�����ɿ����ָ�һ�����ӻ�һ��ָ�������ӡ�
 * 
 * ��������: ��һ�У�n����ʾh����Ԫ�ظ��� �ڶ��У�n��h����Ԫ�� �����У�m����ʾw����Ԫ�ظ��� �����У�m��w����Ԫ��
 * 
 * �������: ��̨����ѧ������
 * 
 * ��������1:
 * 
 * 3 2 2 3 2 3 1
 * 
 * �������1: 1
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
		// ��ʼ�ַ��ɿ�������̰���㷨������С�Ŀ�ʼ����
		for (int i = 0, j = 0; i < cho.length && j < child.length; i++) {
			if (cho[i] >= child[j]) {
				count++;
				j++;
			}
		}
		return count;
	}
}
