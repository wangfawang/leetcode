package getuglyNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ������������7��
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * 
 * @author hasee
 *
 */

/*
 * ˵��˼·�����p�ǳ�������ôp=2^x * 3^y * 5^z ��ôֻҪ����x,y,z��ͬ��ֵ���ܵõ���ͬ�ĳ�����
 * ���Ҫ˳���ҳ�������Ҫ֪�����漸���أ�fei���㣨hua���� �����κγ���p�� ��һ����ô2*p,3*p,5*p���ǳ���������2*p<3*p<5*p
 * ���������p<q, ��ô2*p<2*q,3*p<3*q,5*p<5*q ����˵˵�㷨˼�룺 ��˼·��
 * ����ֻ�ñȽ�3���������ڳ�2����С���������ڳ�3����С���������ڳ�5����С��
 */
public class Solution {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (list.size() < index) {// ѭ������
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
