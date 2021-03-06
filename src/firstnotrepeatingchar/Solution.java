package firstnotrepeatingchar;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1.
 * 
 * @author hasee
 *
 */
public class Solution {

	/*
	 * 解题思路哈，其实主要还是hash，利用每个字母的ASCII码作hash来作为数组的index。首先用一个58长度的数组来存储每个字母出现的次数，
	 * 为什么是58呢，主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，而每个字母的index=int(word
	 * )-65，比如g=103-65=38，而数组中具体记录的内容是该字母出现的次数，最终遍历一遍字符串，找出第一个数组内容为1的字母就可以了，
	 * 时间复杂度为O(n)
	 */
	public int FirstNotRepeatingChar(String str) {
		int[] words = new int[58];// hash表，存储每个字母的出现次数

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

		Map<Character, Integer> map = new HashMap<>();// hash表，存储每个字母的出现次数

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
