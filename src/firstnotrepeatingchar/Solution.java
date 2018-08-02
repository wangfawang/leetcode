package firstnotrepeatingchar;

import java.util.HashMap;
import java.util.Map;

/**
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1.
 * 
 * @author hasee
 *
 */
public class Solution {

	/*
	 * ����˼·������ʵ��Ҫ����hash������ÿ����ĸ��ASCII����hash����Ϊ�����index��������һ��58���ȵ��������洢ÿ����ĸ���ֵĴ�����
	 * Ϊʲô��58�أ���Ҫ������A-Z��Ӧ��ASCII��Ϊ65-90��a-z��Ӧ��ASCII��ֵΪ97-122����ÿ����ĸ��index=int(word
	 * )-65������g=103-65=38���������о����¼�������Ǹ���ĸ���ֵĴ��������ձ���һ���ַ������ҳ���һ����������Ϊ1����ĸ�Ϳ����ˣ�
	 * ʱ�临�Ӷ�ΪO(n)
	 */
	public int FirstNotRepeatingChar(String str) {
		int[] words = new int[58];// hash���洢ÿ����ĸ�ĳ��ִ���

		for (int i = 0; i < str.length(); i++) {
			words[(int) (str.charAt(i)) - 65] += 1;
		}
		for (int i = 0; i < str.length(); i++) {
			if (words[(int) (str.charAt(i)) - 65] == 1)
				return i;
		}
		return -1;
	}

	public int FirstNotRepeatingChar1(String str) {

		Map<Character, Integer> map = new HashMap<>();// hash���洢ÿ����ĸ�ĳ��ִ���

		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				int count = map.get(str.charAt(i));
				map.put(str.charAt(i), ++count);
			} else {
				map.put(str.charAt(i), 1);
			}

		}
		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().FirstNotRepeatingChar1("google"));
	}
}
