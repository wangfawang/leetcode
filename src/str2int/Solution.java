package str2int;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 
 * 
 * 
 * +2147483647 1a33
 * 
 * 输出 复制
 * 
 * 2147483647 0
 * 
 * 
 */
public class Solution {
	public int StrToInt(String str) {
		if (str.length() == 0) {
			return 0;
		} else if (str.length() == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
			return 0;
		} else {
			int flag = 0;// 用来标记正负号，1是+,2是-
			boolean error = false;// 用来判断字符串是否出现非数字
			int i = 0;
			// 如果有符号位，则i后移，如果没有，则从第一个开始读数
			if (str.charAt(0) == '+') {
				i++;
				flag = 1;
			} else if (str.charAt(0) == '-') {
				i++;
				flag = 2;
			}
			int result = 0;// 返回结果
			for (int j = i; j < str.length(); j++) {
				char ch = str.charAt(j);
				if ('0' <= ch && ch <= '9') {
					result = 10 * result + (ch - '0');
				} else {
					error = true;
					break;
				}
			}
			if (!error) {
				if (flag == 2) {
					result = result * -1;
				}
				return result;
			} else {
				return 0;
			}

		}
	}

	public static void main(String[] args) {
		String str = "-12a34";
		System.out.println(new Solution().StrToInt(str));

	}
}
