package printMinNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author hasee
 *
 */
public class Solution {

	/*
	 * 解题思路： 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
	 * 排序规则如下： 若ab > ba 则 b在前， 若ab < ba 则 a在前，
	 */
	public String PrintMinNumber(int[] numbers) {
		if (numbers.length == 0 || numbers == null)
			return "";
		StringBuilder sb = new StringBuilder();
		int len = numbers.length;
		String[] str = new String[len];
		for (int i = 0; i < len; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, new Comparator<String>() {// 排序使用的比较器
			@Override
			public int compare(String s1, String s2) {// 比较规则s1和s2分别是str中的元素
				// TODO Auto-generated method stub
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);// 排序规则如下，若c1>c2,则s2,s1;若c1<c2,则s1,s2.
			}
		});

		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
}
