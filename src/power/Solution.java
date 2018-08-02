package power;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author hasee
 *
 */
public class Solution {
	public double Power(double base, int exponent) {
		double result = 1.0;
		int e = Math.abs(exponent);
		if(base==0&&e==0)
			throw new RuntimeException("0的0次方无意义");
		if(base==0&&exponent<0)
			throw new RuntimeException("分母不能为0");
		for (int i = 0; i < e; i++) {
			result *=base;
		}
		if(exponent<0)
			result =1/result;
		return result;
		
	}
}
