package rectcover;
/**
 * 
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * 
依旧是斐波那契数列
2*n的大矩形，和n个2*1的小矩形
其中target*2为大矩阵的大小
有以下几种情形：
1.target <= 0 大矩形为<= 2*0,直接return 0；
2.target = 1大矩形为2*1，只有一种摆放方法，return1；
3.target = 2 大矩形为2*2，有两种摆放方法，return2；
4.target = n(n>=3) 分为两步考虑：
        第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
√ 		
√ 	
第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)
因为，摆放了一块1*2的小矩阵（用√√表示），对应下方的1*2（用××表示）摆放方法就确定了，所以为f(targte-2)
√ 	√ 		
× 	× 		
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
