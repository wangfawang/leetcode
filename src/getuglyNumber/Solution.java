package getuglyNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author hasee
 *
 */

/*
 * 说下思路，如果p是丑数，那么p=2^x * 3^y * 5^z 那么只要赋予x,y,z不同的值就能得到不同的丑数。
 * 如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。 对于任何丑数p： （一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
 * （二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q 现在说说算法思想： 该思路：
 * 我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
 */
public class Solution {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (list.size() < index) {// 循环条件
			int m2 = list.get(i2) * 2;
			int m3 = list.get(i3) * 3;
			int m5 = list.get(i5) * 5;
			int min = Math.min(m2, Math.min(m3, m5));
			list.add(min);
			if (m2 == min)
				i2++;
			if (m3 == min)
				i3++;
			if (m5 == min)
				i5++;
		}
		return list.get(index - 1);

	}

	public static void main(String[] args) {
		System.out.println(new Solution().GetUglyNumber_Solution(3));
	}
}
