package isContinuous;

import java.util.Arrays;

/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,�����Լ�������,
 * �����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh My
 * God!������˳��.....LL��������,��������,������\С
 * �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So
 * Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ�
 * ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
 * 
 * @author hasee
 *
 */
public class Solution {

	/*
	 * 
	 * 1������ 2�����������������ּ������ 3������0�ĸ��� 4�������С���������ڼ������������˳�� 5��������ֶ��ӣ�����˳��
	 * 
	 */
	public boolean isContinuous(int[] numbers) {
		int count = 0;// ͳ�ƴ�С���ĸ���
		int gap = 0;// ͳ���������ּ������
		if (numbers.length == 0)
			return false;
		Arrays.sort(numbers);// 1������
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] == 0)
				count++;
			else {
				if (numbers[i] == numbers[i + 1])// ���ӣ�ֱ�ӷ���
					return false;
				gap += numbers[i + 1] - numbers[i] - 1;
			}
		}
		return count >= gap ? true : false;
	}

	public static void main(String[] args) {
		int[] numbers = { 0, 0, 0, 0, 13 };
		System.out.println(new Solution().isContinuous(numbers));
	}
}
