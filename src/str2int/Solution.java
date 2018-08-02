package str2int;

/**
 * ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 * 
 * 
 * 
 * +2147483647 1a33
 * 
 * ��� ����
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
			int flag = 0;// ������������ţ�1��+,2��-
			boolean error = false;// �����ж��ַ����Ƿ���ַ�����
			int i = 0;
			// ����з���λ����i���ƣ����û�У���ӵ�һ����ʼ����
			if (str.charAt(0) == '+') {
				i++;
				flag = 1;
			} else if (str.charAt(0) == '-') {
				i++;
				flag = 2;
			}
			int result = 0;// ���ؽ��
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
