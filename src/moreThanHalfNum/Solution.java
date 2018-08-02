package moreThanHalfNum;

/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * 
 * @author hasee
 *
 */
public class Solution {
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array.length == 0)
			return 0;
		int count = 1;
		int num = array[0];
		for (int i = 1; i < array.length; i++) {
			if (num == array[i])
				count++;
			else
				count--;
			if (count == 0) {
				num = array[i];
				count = 1;
			}
		}
		// ����ѭ���ҵ��������ظ�����������
		// ��֤�Ƿ񳬹����鳤�ȵ�һ��
		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num)
				count++;
		}
		if (count * 2 > array.length)
			return num;
		else
			return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(new Solution().MoreThanHalfNum_Solution(arr));
	}
}
