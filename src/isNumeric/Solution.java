package isNumeric;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123",
 * "3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class Solution {
	private int index = 0;

	// 正则表达式解法
	public boolean isNumeric1(char[] str) {
		String string = String.valueOf(str);
		return string.matches("[\\+\\-]?\\d*[\\.\\d]?([eE][\\+\\-]?\\d+)?");
	}

	public boolean isNumeric(char[] str) {
		if (str.length < 1)
			return false;
		boolean flag = scanInteger(str);
		// 第一个非数字符号只能是.,否则就会false
		if (index < str.length && str[index] == '.') {
			index++;
			flag = scanInteger(str) || flag;// 如果是-.234，则-后是没有数字的，所以此时flag=false，scanInteger(str)是true。
			// 所以如果是&&就是false了。因此用||
		}

		// 第二个非数字符号只能是e|E了，否则就不是数字
		if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			index++;
			flag = scanInteger(str) && flag;
		}
		return flag && index == str.length;// 只要没有走到最后，说明还有除了.和E|e之外的多于符号
	}

	private boolean scanInteger(char[] str) {
		if (index < str.length && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		return scanUnsignedInteger(str);
	}

	private boolean scanUnsignedInteger(char[] str) {
		int start = index;
		while (index < str.length && '0' <= str[index] && str[index] <= '9') {
			index++;// index用来存储非数字下标
		}
		return start < index;// 返回是否有整数
	}

	public static void main(String[] args) {
		char[] ch = "-.123".toCharArray();
		System.out.println(new Solution().isNumeric(ch));
	}
}
