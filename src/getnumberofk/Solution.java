package getnumberofk;

/**
 * ͳ��һ�����������������г��ֵĴ���
 * 
 * @author hasee
 *
 */
public class Solution {
	//˳����ң�����Ч�ʵͣ�ƽ�����ҳ���n
	public int GetNumberOfK(int[] array, int k) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == k)
				count++;
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,1,2,4,6};
		System.out.println(new Solution().GetNumberOfK(arr, 3));
	}
}
