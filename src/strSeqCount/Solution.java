package strSeqCount;

import java.util.Scanner;

/**
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 * 
 * @author hasee
 *
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = s.split("[\\D]+");//使用非数字分割字符串
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
