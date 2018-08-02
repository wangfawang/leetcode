package isNumeric;

/**
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ���"+100","5e2","-123",
 * "3.1416"��"-1E-16"����ʾ��ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */

public class Solution {
	private int index = 0;

	// ������ʽ�ⷨ
	public boolean isNumeric1(char[] str) {
		String string = String.valueOf(str);
		return string.matches("[\\+\\-]?\\d*[\\.\\d]?([eE][\\+\\-]?\\d+)?");
	}

	public boolean isNumeric(char[] str) {
		if (str.length < 1)
			return false;
		boolean flag = scanInteger(str);
		// ��һ�������ַ���ֻ����.,����ͻ�false
		if (index < str.length && str[index] == '.') {
			index++;
			flag = scanInteger(str) || flag;// �����-.234����-����û�����ֵģ����Դ�ʱflag=false��scanInteger(str)��true��
			// ���������&&����false�ˡ������||
		}

		// �ڶ��������ַ���ֻ����e|E�ˣ�����Ͳ�������
		if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			index++;
			flag = scanInteger(str) && flag;
		}
		return flag && index == str.length;// ֻҪû���ߵ����˵�����г���.��E|e֮��Ķ��ڷ���
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
			index++;// index�����洢�������±�
		}
		return start < index;// �����Ƿ�������
	}

	public static void main(String[] args) {
		char[] ch = "-.123".toCharArray();
		System.out.println(new Solution().isNumeric(ch));
	}
}
