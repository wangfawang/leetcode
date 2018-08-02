package match;

/*
 * 当模式中的第二个字符不是“*”时：
1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

而当模式中的第二个字符是“*”时：
如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
1、模式后移2字符，相当于x*被忽略；
2、字符串后移1字符，模式后移2字符；
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；

这里需要注意的是：Java里，要时刻检验数组是否越界。
 */
public class Solution {

	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {// 如果字符串和模式都为空，则返回false
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		return matchCore(str, strIndex, pattern, patternIndex);
	}

	public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		// 检验校验结果，如果str到尾，pattern到尾，则匹配成功
		if (strIndex == str.length && patternIndex == pattern.length)
			return true;
		// 当pattern到尾了，但是str没结束，说明匹配失败
		if (patternIndex == pattern.length && strIndex != str.length)
			return false;

		// 如果模式的第二个是'*'
		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {// 数组越界判断
			// 如果字符串第一个和模式第一个匹配(注意：.能匹配任何字符)，分三种情况讨论
			if (((strIndex != str.length && str[strIndex] == pattern[patternIndex]))
					|| (strIndex != str.length && pattern[patternIndex] == '.')) {
				return matchCore(str, strIndex, pattern, patternIndex + 2)// 跳过模式中x*，直接用下一个模式匹配第一个字符
						|| matchCore(str, strIndex + 1, pattern, patternIndex + 2)// 字符串下移一位，模式下移两位，开始匹配第二个字符
						|| matchCore(str, strIndex + 1, pattern, patternIndex);// 模式不变，字符串下移，继续用该模式匹配第二个字符
			} // 字符串第一个和模式第一个不匹配
			else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);// 跳过模式中x*，直接用下一个模式匹配第一个字符
			}
		}

		// 模式第2个不是*(备注：存在模式长度=1的情况，或者模式第二个确实不是*，即上一个if中有一个不满足才会到这里判断)
		// 且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
				|| (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		return false;
	}

	public static void main(String[] args) {
		char[] str = "a".toCharArray();
		char[] pattern = ".".toCharArray();
		new Solution().match(str, pattern);
	}
}
