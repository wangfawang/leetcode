package min4revArr;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * 
 * @author hasee
 *
 */
public class Solution {

	public int minNumberInRotateArray(int[] array) {
		int size = array.length;
		if (size == 0) {
			return 0;
		} // if
		int left = 0, right = size - 1;
		int mid = 0;
		// array[left] >= array[right] ȷ����ת
		while (array[left] >= array[right]) {
			// �ֽ��
			if (right - left == 1) {
				mid = right;
				break;
			} // if
			mid = left + (right - left) / 2;
			// array[left] array[right] array[mid]�������
			// �޷�ȷ���м�Ԫ��������ǰ�滹�Ǻ���ĵ���������
			// ֻ��˳�����
			if (array[left] == array[right] && array[left] == array[mid]) {
				return MinOrder(array, left, right);
			} // if
				// �м�Ԫ��λ��ǰ��ĵ���������
				// ��ʱ��СԪ��λ���м�Ԫ�صĺ���
			if (array[mid] >= array[left]) {
				left = mid;
			} // if
				// �м�Ԫ��λ�ں���ĵ���������
				// ��ʱ��СԪ��λ���м�Ԫ�ص�ǰ��
			else {
				right = mid;
			} // else
		} // while
		return array[mid];
	}

	
	
	
	private int MinOrder(int[] array, int left, int right) {
		int result = array[left];
		for (int i = left + 1; i < right; ++i) {
			if (array[i] < result) {
				result = array[i];
			} // if
		} // for
		return result;
	}
}
