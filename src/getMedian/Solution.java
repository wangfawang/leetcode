package getMedian;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ��
 * ��ô��λ������������ֵ����֮���м���������ƽ��ֵ������ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 * 
 * @author hasee
 *
 */
public class Solution {
	ArrayList<Integer> al = new ArrayList<>();

	public void Insert(Integer num) {
		al.add(num);

	}

	public Double GetMedian() {
		Collections.sort(al);
		int size = al.size();
		if (size % 2 != 0) {// ������
			return (double) (al.get((0 + size - 1) / 2));
		} else {// ż����
			int num1 = al.get(size / 2);
			int num2 = al.get(size / 2 - 1);
			return (double) (num1 + num2) / 2;

		}
	}

}
