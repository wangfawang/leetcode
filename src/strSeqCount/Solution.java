package strSeqCount;

import java.util.Scanner;

/**
 * ����һ���ַ���str������ַ���str�е�����������ִ�
 * 
 * @author hasee
 *
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = s.split("[\\D]+");//ʹ�÷����ַָ��ַ���
		String result = "";
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > max) {
				max = arr[i].length();
				result = arr[i];
			}
		}
		System.out.println(result);
	}
}
