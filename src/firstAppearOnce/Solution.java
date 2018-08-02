package firstAppearOnce;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 输出描述:
 * 
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
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
