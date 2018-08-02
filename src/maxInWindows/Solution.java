package maxInWindows;

import java.util.ArrayList;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 * {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 * 
 * @author hasee
 *
 */
public class Solution {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		if (size < 0 || num == null)
			return null;
		ArrayList<Integer> al = new ArrayList<>();
		if (size == 0)
			return al;
		for (int i = 0; i <= num.length - size; i++) {
			int max = num[i];
			int j = 1;
			while (j < size) {
				if (num[i + j] > max)
					max = num[i + j];
				j++;
			}
			al.add(max);
		}
		return al;
	}
}
