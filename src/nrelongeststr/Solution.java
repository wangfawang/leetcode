package nrelongeststr;

import java.util.HashSet;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 
 * 示例：
 * 
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 *
 * @author hasee
 *
 */
public class Solution {
	/**
	 * 算法思想：
	 * 
	 * 设置两个下标标识，初始时都位于数组的头部，并设置一个HashSet。标识runner先往后走，并将经过的字符放入HashSet中，
	 * 当存在重复的字符时停止移动；此时，标识walker在后面追，直到walker的字符和runner的字符相同为止，
	 * 此时walker与runner之间的字符是无重复的字符串，将长度记录为max。进行一遍遍历后可以得到最长字符串的长度值。
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		HashSet<Character> hs = new HashSet<Character>();
		int walker = 0;
		int runner = 0;
		int max = 0;
		if (s == null || s.length() == 0)
			return 0;
		while (runner < s.length()) {
			if(hs.contains(s.charAt(runner))){
				while (s.charAt(walker)!= s.charAt(runner)) {
					hs.remove(s.charAt(walker));
					walker++;
				}
				if (max<runner-walker) {
					max= runner- walker;
				}
				walker++;
			}else{
				hs.add(s.charAt(runner));
			}
			runner++;
		}

		max = Math.max(max, runner-walker);
		return max;
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		 if (s == null || s.length() == 0)
//		 return 0;
//		 HashSet<Character> set = new HashSet<Character>();
//		 int max = 0;
//		 int walker = 0;
//		 int runner = 0;
//		 while (runner < s.length()) {
//		 if (set.contains(s.charAt(runner))) {
//		 while (s.charAt(walker) != s.charAt(runner)) {
//		 set.remove(s.charAt(walker));
//		 walker++;
//		 }
//		 if (max < runner - walker) {
//		 max = runner - walker;
//		 }
//		 walker++;
//		 } else {
//		 set.add(s.charAt(runner));
//		 }
//		 runner++;
//		 }
//		 max = Math.max(max, runner - walker);
//		 return max;
	}
}
