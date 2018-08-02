package rectcover;
/**
 * 
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * 
 * 
������쳲���������
2*n�Ĵ���Σ���n��2*1��С����
����target*2Ϊ�����Ĵ�С
�����¼������Σ�
1.target <= 0 �����Ϊ<= 2*0,ֱ��return 0��
2.target = 1�����Ϊ2*1��ֻ��һ�ְڷŷ�����return1��
3.target = 2 �����Ϊ2*2�������ְڷŷ�����return2��
4.target = n(n>=3) ��Ϊ�������ǣ�
        ��һ�ΰڷ�һ�� 2*1 ��С������ڷŷ����ܹ�Ϊf(target - 1)
�� 		
�� 	
��һ�ΰڷ�һ��1*2��С������ڷŷ����ܹ�Ϊf(target-2)
��Ϊ���ڷ���һ��1*2��С�����á̡̱�ʾ������Ӧ�·���1*2���á�����ʾ���ڷŷ�����ȷ���ˣ�����Ϊf(targte-2)
�� 	�� 		
�� 	�� 		
 * 
 * @author hasee
 *
 */
public class Solution {
	public int RectCover(int target) {
		if (target<0) {
			return -1;
		}
		else if(target<=2)
			return target;
		int[] result = new int[target+1];
		for (int i = 0; i <=2; i++) {
			result[i]=i;
		}
		for (int i = 3; i <=target; i++) {
			result[i]=result[i-1]+result[i-2];
		}
		return result[target];
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().RectCover(4));
	}
}
