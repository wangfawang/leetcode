package printMinNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}��
 * ���ӡ���������������ųɵ���С����Ϊ321323��
 * 
 * @author hasee
 *
 */
public class Solution {

	/*
	 * ����˼·�� �Ƚ���������ת����String���飬Ȼ��String������������ź�����ַ�������ƴ�ӳ������ؼ������ƶ��������
	 * ����������£� ��ab > ba �� b��ǰ�� ��ab < ba �� a��ǰ��
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
		Arrays.sort(str, new Comparator<String>() {// ����ʹ�õıȽ���
			@Override
			public int compare(String s1, String s2) {// �ȽϹ���s1��s2�ֱ���str�е�Ԫ��
				// TODO Auto-generated method stub
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);// ����������£���c1>c2,��s2,s1;��c1<c2,��s1,s2.
			}
		});

		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
}
