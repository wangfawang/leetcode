package firstAppearOnce;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"�� �������:
 * 
 * �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
 * 
 * 
 * @author hasee
 *
 */
public class Solution {
	StringBuilder sb = new StringBuilder();
	Map<Character, Integer> map = new HashMap<>();

	// Insert one char from stringstream
	public void Insert(char ch) {
		sb.append(ch);
		if (map.containsKey(ch)) {
			int count = map.get(ch);
			map.put(ch, ++count);
		} else {
			map.put(ch, 1);
		}

	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		char[] ch = sb.toString().toCharArray();
		for (char c : ch) {
			if (map.get(c) == 1)
				return c;
		}
		return '#';
	}
}
