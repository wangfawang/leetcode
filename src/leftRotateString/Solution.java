package leftRotateString;

/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S��
 * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK��
 * �㶨����
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

	// ԭ��YX = (XTY T)T
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
