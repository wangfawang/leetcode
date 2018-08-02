package jumpfloor;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * 
 * ���ڱ���,ǰ��ֻ�� һ�� 1�׻���2�׵�������
 * 
 * a.�������������1�׻���2�ף���ô�ٶ���һ��������һ�ף���ôʣ�µ���n-1��̨�ף�������f(n-1);
 * 
 * b.�ٶ���һ��������2�ף���ôʣ�µ���n-2��̨�ף�������f(n-2)
 * 
 * c.��a\b������Եó�������Ϊ: f(n) = f(n-1) + f(n-2)
 * 
 * d.Ȼ��ͨ��ʵ�ʵ�������Եó���ֻ��һ�׵�ʱ�� f(1) = 1 ,ֻ�����׵�ʱ������� f(2) = 2
 * 
 * 
 * 
 * e.���Է������յó�����һ��쳲��������У�
 * 
 * 
 * 
 * 		  | 1, (n=1)
 * 
 * f(n) = | 2, (n=2) 
 * 
 * 		  | f(n-1)+f(n-2) ,(n>2,nΪ����)
 * 
 *
 * @author hasee
 *
 */
public class Solution {

	public int JumpFloor(int target) {
		if (target <= 0)
			return 0;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		int[] result = new int[target + 2];
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i <= target; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[target];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().JumpFloor(6));
	}

}
