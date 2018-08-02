package permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,
 * bca,cab和cba。
 * 
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母;;
 * 
 * @author hasee
 *
 */
public class Solution {
	public static void main(String[] args) {
		Solution p = new Solution();
		System.out.println(p.Permutation("abc").toString());
	}

	public ArrayList<String> Permutation(String str) {
		List<String> res = new ArrayList<>();
		if (str != null && str.length() > 0) {
			PermutationHelper(str.toCharArray(), 0, res);
			Collections.sort(res);// 将全排列重新排序
		}
		return (ArrayList) res;
	}

	/*
	 * 先固定原字符串，再从后向前固定，从后向前交换，得到全排列种类.(回溯法)
	 */
	public void PermutationHelper(char[] cs, int i, List<String> list) {
		if (i == cs.length - 1) {
			String val = String.valueOf(cs);
			if (!list.contains(val))
				list.add(val);
		} else {
			for (int j = i; j < cs.length; j++) {// i表示已经固定的数
				swap(cs, i, j);// 交换后面的位置，继续递归
				PermutationHelper(cs, i + 1, list);
				swap(cs, i, j);// 递归完以后，恢复之前的顺序
			}
		}
	}

	public void swap(char[] cs, int i, int j) {
		char tmp = cs[i];
		cs[i] = cs[j];
		cs[j] = tmp;
	}
}
