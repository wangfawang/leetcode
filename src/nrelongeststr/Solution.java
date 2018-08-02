package nrelongeststr;

import java.util.HashSet;

/**
 * ����һ���ַ������ҳ��������ظ��ַ�����Ӵ��ĳ��ȡ�
 * 
 * ʾ����
 * 
 * ���� "abcabcbb" ��û���ظ��ַ�����Ӵ��� "abc" ����ô���Ⱦ���3��
 * 
 * ���� "bbbbb" ������Ӵ����� "b" ��������1��
 * 
 * ���� "pwwkew" ����Ӵ��� "wke" ��������3����ע��𰸱�����һ���Ӵ���"pwke" �� ������ �������Ӵ���
 *
 * @author hasee
 *
 */
public class Solution {
	/**
	 * �㷨˼�룺
	 * 
	 * ���������±��ʶ����ʼʱ��λ�������ͷ����������һ��HashSet����ʶrunner�������ߣ������������ַ�����HashSet�У�
	 * �������ظ����ַ�ʱֹͣ�ƶ�����ʱ����ʶwalker�ں���׷��ֱ��walker���ַ���runner���ַ���ͬΪֹ��
	 * ��ʱwalker��runner֮����ַ������ظ����ַ����������ȼ�¼Ϊmax������һ���������Եõ���ַ����ĳ���ֵ��
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
