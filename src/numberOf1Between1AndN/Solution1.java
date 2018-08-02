package numberOf1Between1AndN;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、
 * 13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * 
 * @author hasee
 *
 */
public class Solution1 {
	// 暴力解法
	public int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			sb.append(i);
		}
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '1')
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution1().NumberOf1Between1AndN_Solution(10000));
	}
}
