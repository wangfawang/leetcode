package maxInWindows;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * @author hasee
 *
 */
public class Solution {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		if (size < 0 || num == null)
			return null;
		ArrayList<Integer> al = new ArrayList<>();
		if (size == 0)
			return al;
		for (int i = 0; i <= num.length - size; i++) {
			int max = num[i];
			int j = 1;
			while (j < size) {
				if (num[i + j] > max)
					max = num[i + j];
				j++;
			}
			al.add(max);
		}
		return al;
	}
}
