package tanxinsuanfa;

/**
 * 2.Ǯ���������� ������������ǵ��ճ������о͸����ձ��ˡ�����1Ԫ��2Ԫ��5Ԫ��10Ԫ��20Ԫ��50Ԫ��100Ԫ��ֽ�ҷֱ���c0, c1, c2, c3,
 * c4, c5,
 * c6�š�����Ҫ����ЩǮ��֧��KԪ������Ҫ�ö�����ֽ�ң���̰���㷨��˼�룬����Ȼ��ÿһ������������ֵ���ֽ�Ҽ��ɡ����ճ�������������Ȼ��ȻҲ����ô���ġ�
 * �ڳ������Ѿ����Ƚ�Value���մ�С�����˳���źá�
 * 
 * @author hasee
 *
 */
public class Solution {

	/**
	 * @param money
	 *            ��������
	 * @param values
	 *            ������ֵֽ��
	 * @param counts
	 *            ��Ӧ��ֵֽ������
	 * @return result ������
	 */
	public static int[] changeMoney(int money, int[] values, int[] counts) {
		// ������
		int[] result = new int[values.length];
		// ÿһ������������ֵ���ֽ��
		for (int i = values.length - 1; i >= 0; i--) {
			// ��Ҫ�����ֵ������
			int num = Math.min(money / values[i], counts[i]);
			// ʣ���Ǯ
			money = money - num * values[i];
			result[i] += num;
		}
		return result;
	}

	private static void print(int[] numbers, int[] values) {
		for (int i = 0; i < values.length; i++) {
			if (numbers[i] != 0) {
				System.out.println("��Ҫ���Ϊ" + values[i] + "�������" + numbers[i] + "��");
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
