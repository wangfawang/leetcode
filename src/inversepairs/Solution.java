package inversepairs;

/**
 * 
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007 ��������:
 * 
 * ��Ŀ��֤�����������û�е���ͬ������
 * 
 * ���ݷ�Χ��
 * 
 * ����%50������,size<=10^4
 * 
 * ����%75������,size<=10^5
 * 
 * ����%100������,size<=2*10^5
 * 
 * ʾ��1 ����
 * 
 * 1,2,3,4,5,6,7,0
 *
 * ���
 * 
 * 7
 * 
 * 
 * @author hasee
 *
 */
public class Solution {
	
	//�������O(n^2),�ᳬʱ
	public int InversePairs(int[] array) {
		int count = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > array[i])
					count++;
			}
		}
		return count % 1000000007;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0,-1};
		System.out.println(new Solution().InversePairs(arr));
	}
}
