package match;

/*
 * ��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
2����� �ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��

����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ��
1��ģʽ����2�ַ����൱��x*�����ԣ�
2���ַ�������1�ַ���ģʽ����2�ַ���
3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��

������Ҫע����ǣ�Java�Ҫʱ�̼��������Ƿ�Խ�硣
 */
public class Solution {

	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {// ����ַ�����ģʽ��Ϊ�գ��򷵻�false
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		return matchCore(str, strIndex, pattern, patternIndex);
	}

	public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		// ����У���������str��β��pattern��β����ƥ��ɹ�
		if (strIndex == str.length && patternIndex == pattern.length)
			return true;
		// ��pattern��β�ˣ�����strû������˵��ƥ��ʧ��
		if (patternIndex == pattern.length && strIndex != str.length)
			return false;

		// ���ģʽ�ĵڶ�����'*'
		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {// ����Խ���ж�
			// ����ַ�����һ����ģʽ��һ��ƥ��(ע�⣺.��ƥ���κ��ַ�)���������������
			if (((strIndex != str.length && str[strIndex] == pattern[patternIndex]))
					|| (strIndex != str.length && pattern[patternIndex] == '.')) {
				return matchCore(str, strIndex, pattern, patternIndex + 2)// ����ģʽ��x*��ֱ������һ��ģʽƥ���һ���ַ�
						|| matchCore(str, strIndex + 1, pattern, patternIndex + 2)// �ַ�������һλ��ģʽ������λ����ʼƥ��ڶ����ַ�
						|| matchCore(str, strIndex + 1, pattern, patternIndex);// ģʽ���䣬�ַ������ƣ������ø�ģʽƥ��ڶ����ַ�
			} // �ַ�����һ����ģʽ��һ����ƥ��
			else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);// ����ģʽ��x*��ֱ������һ��ģʽƥ���һ���ַ�
			}
		}

		// ģʽ��2������*(��ע������ģʽ����=1�����������ģʽ�ڶ���ȷʵ����*������һ��if����һ��������Żᵽ�����ж�)
		// ���ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
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
