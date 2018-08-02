package beibaowenti;

import java.util.Arrays;

/**
 * 
 * ��һ������������������M=150����7����Ʒ����Ʒ���Էָ�������С��
*Ҫ�󾡿�����װ�뱳���е���Ʒ�ܼ�ֵ��󣬵����ܳ�����������
*��Ʒ A B C D E F G
*���� 35 30 60 50 40 10 25
*��ֵ 10 40 30 50 35 40 30
*�ǵõ�ʱѧ�㷨��ʱ�򣬾���������ӣ�����˵�ܾ��䡣
*������
*Ŀ�꺯���� ��pi���
*Լ��������װ�����Ʒ��������������������������wi<=M( M=150)
*��1������̰�ĵĲ��ԣ�ÿ����ѡ��ֵ������Ʒװ�뱳�����õ��Ľ���Ƿ����ţ�
*��2��ÿ����ѡ��ռ������С����Ʒװ���Ƿ��ܵõ����Ž⣿
*��3��ÿ��ѡȡ��λ������ֵ������Ʒ����Ϊ�Ȿ��Ĳ���?
*̰���㷨�Ǻܳ������㷨֮һ�����������������У�����̰�Ĳ��Լ򵥡����ǣ�����Ҫ֤��������������õ���Ŀ���㷨�С�һ����˵��̰���㷨��֤��Χ����������������Ž�һ������̰�Ĳ����д��ڵ�����������Ž�����ġ�
*���ڱ������е�3��̰�Ĳ��ԣ����޷����������޷���֤�����������£�
*��1��̰�Ĳ��ԣ�ѡȡ��ֵ����ߡ�������
*W=30
*��Ʒ��A B C
*������28 12 12
*��ֵ��30 20 20
*���ݲ��ԣ�����ѡȡ��ƷA�����������޷���ѡȡ�ˣ����ǣ�ѡȡB��C����á�
*��2��̰�Ĳ��ԣ�ѡȡ������С�����ķ������һ�ֲ��Եķ�����ࡣ
*��3��̰�Ĳ��ԣ�ѡȡ��λ������ֵ������Ʒ��������
*W=30
*��Ʒ��A B C
*������28 20 10
*��ֵ��28 20 10
*���ݲ��ԣ�������Ʒ��λ������ֵһ���������޷��������в��������жϣ����ѡ��A����𰸴��� 
 * @author hasee
 *
 */

/**
 * https://blog.csdn.net/u014394715/article/details/51162960
 * 
 * ������������������Ľⷨ��Ӧ����ʹ��̰���㷨������Ӧ��ʹ�ö�̬�滮�㷨
 * ��̬�滮����Ļ���˼��ǳ��򵥡������ϣ���Ҫ��һ���������⣬������Ҫ���䲻ͬ���֣��������⣩���ٺϲ�������Ľ��Եó�ԭ����Ľ⡣
 * �ӿռ��Ͽ�ʼ��ÿ����һ��Ԫ�ؾ����������Ž⣬ֱ������Ԫ�ؼӽ������͵õ����ܵ����Ž⡣
 * 
 * ���⣺�б�ŷֱ�Ϊa,b,c,d,e�������Ʒ�����ǵ������ֱ���2,2,6,5,4�����ǵļ�ֵ�ֱ���6,3,5,4,6�����ڸ��������Ϊ10�ı�����
 * ����ñ�����װ�����Ʒ�������ļ�ֵ�ܺͣ�
 * 
 * 
 * @author hasee
 *
 */
class Package {

	private String name;

	private int weight;

	private int value;

	public Package(String name, int weight, int value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}
}

public class Solution {

	public static int bagWay(Package[] pg, int bagSize) {

		// ��һ��������ʾ��pg[0]��ʼ���η������Ʒ��
		// �ڶ��������������ĳ���,������0������
		int[][] state = new int[pg.length][bagSize + 1];
		int newValue = 0;

		/**
		 * 01������״̬ת������ f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ), f[i-1,j] }
		 * f[i,j]����ǰi����Ʒ��ѡ�����ɼ����ڳ���Ϊ j �ı����У�����ȡ�õ�����ֵ�� Pi��ʾ��i����Ʒ�ļ�ֵ��
		 * ���ߣ�Ϊ�˱�������Ʒ�ܼ�ֵ��󻯣��� i����ƷӦ�÷��뱳������ �� 2. ��a8����Ϊa����Ϊ��8�ĵ�Ԫ�� ���� f[i,j] =
		 * a8= 15 f[i-1,j] = b8 = 9 f[i-1,j-Wi]
		 * ��ʾ����һ������Ϊ6�ı��������ڵ�ǰ�������ؼ�ȥ��Ʒa������������ֻ����Ʒb,c,d,e�ļ���ѡʱ�����������װ�������ֵ
		 * f[i-1,j-Wi] +Pi =b(8 - 2) + 6 = b6 + 6 = 15
		 * 
		 */
		for (int i = 0; i < pg.length; i++) {
			// �����ĳ�����
			for (int j = 1; j < state[i].length; j++) {
				if (i == 0) {
					if (pg[i].getWeight() <= j) {
						state[i][j] = pg[i].getValue();
					}
				} else {
					state[i][j] = state[i - 1][j];
					if (j < pg[i].getWeight()) {
						continue;
					}
					newValue = state[i - 1][j - pg[i].getWeight()] + pg[i].getValue();
					state[i][j] = Math.max(newValue, state[i - 1][j]);
				}
			}
		}
		for (int i = 0; i < state.length; i++) {
			System.out.println(Arrays.toString(state[i]));
		}
		return state[pg.length - 1][bagSize];
	}

	public static void main(String[] args) {
		Package[] pg = { new Package("e", 4, 6), new Package("d", 5, 4), new Package("c", 6, 5), new Package("b", 2, 3),
				new Package("a", 2, 6) };
		System.out.println(bagWay(pg, 10));
	}
}
