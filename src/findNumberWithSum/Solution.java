package findNumberWithSum;

import java.util.ArrayList;

/**
 * 
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ� �������:
 * 
 * ��Ӧÿ�����԰����������������С���������
 * 
 * 
 * @author hasee
 *
 */

/*
 * �������������������ͷβ����ָ��i��j�� ��ai + aj == sum�����Ǵ𰸣����ԽԶ�˻�ԽС�� ��ai + aj
 * >sum����̫���ˣ���Ҫ������ֵ����j -= 1 ��ai + aj < sum����̫С�ˣ���Ҫ�����ֵ��i += 1 O(n)
 */
public class Solution {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		int len = array.length;
		int i = 0;
		int j = len - 1;
		while (i < j) {
			if (array[i] + array[j] == sum) {
				list.add(array[i]);
				list.add(array[j]);
				break;
			} else if (array[i] + array[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
		return list;
	}
}
