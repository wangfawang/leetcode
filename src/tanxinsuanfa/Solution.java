package tanxinsuanfa;

/**
 * 2.钱币找零问题 这个问题在我们的日常生活中就更加普遍了。假设1元、2元、5元、10元、20元、50元、100元的纸币分别有c0, c1, c2, c3,
 * c4, c5,
 * c6张。现在要用这些钱来支付K元，至少要用多少张纸币？用贪心算法的思想，很显然，每一步尽可能用面值大的纸币即可。在日常生活中我们自然而然也是这么做的。
 * 在程序中已经事先将Value按照从小到大的顺序排好。
 * 
 * @author hasee
 *
 */
public class Solution {

	/**
	 * @param money
	 *            找零数额
	 * @param values
	 *            所有面值纸币
	 * @param counts
	 *            对应面值纸币数量
	 * @return result 找零结果
	 */
	public static int[] changeMoney(int money, int[] values, int[] counts) {
		// 找零结果
		int[] result = new int[values.length];
		// 每一步尽可能用面值大的纸币
		for (int i = values.length - 1; i >= 0; i--) {
			// 需要最大面值的张数
			int num = Math.min(money / values[i], counts[i]);
			// 剩余的钱
			money = money - num * values[i];
			result[i] += num;
		}
		return result;
	}

	private static void print(int[] numbers, int[] values) {
		for (int i = 0; i < values.length; i++) {
			if (numbers[i] != 0) {
				System.out.println("需要面额为" + values[i] + "的人民币" + numbers[i] + "张");
			}
		}
	}

	public static void main(String[] args) {
		int[] values = { 1, 2, 5, 10, 20, 50, 100 };
		int[] counts = { 3, 4, 5, 3, 4, 5, 3 };
		int[] numbers = changeMoney(421, values, counts);
		print(numbers, values);
	}
}
