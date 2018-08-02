package leftRotateString;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，
 * 搞定它！
 * 
 * @author hasee
 *
 */
public class Solution {
	public String LeftRotateString(String str, int n) {
		if (n > str.length())
			return "";
		String firstStr = str.substring(0, n);
		String lastStr = str.substring(n, str.length());
		return lastStr + firstStr;
	}

	// 原理：YX = (XTY T)T
	public String LeftRotateString1(String str, int n) {
		if (n > str.length())
			return "";
		String XT = reverseString(str.substring(0, n));
		String YT = reverseString(str.substring(n, str.length()));
		String YX = reverseString(XT + YT);
		return YX;
	}

	public String reverseString(String str) {
		String reverseStr = "";
		for (int i = 0; i < str.length(); i++) {
			reverseStr = str.charAt(i) + reverseStr;
		}
		return reverseStr;
	}
}
