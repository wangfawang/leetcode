package power;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * @author hasee
 *
 */
public class Solution {
	public double Power(double base, int exponent) {
		double result = 1.0;
		int e = Math.abs(exponent);
		if(base==0&&e==0)
			throw new RuntimeException("0��0�η�������");
		if(base==0&&exponent<0)
			throw new RuntimeException("��ĸ����Ϊ0");
		for (int i = 0; i < e; i++) {
			result *=base;
		}
		if(exponent<0)
			result =1/result;
		return result;
		
	}
}
