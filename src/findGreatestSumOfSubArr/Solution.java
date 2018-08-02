package findGreatestSumOfSubArr;

/**
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
 * ������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2
 * ,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס��(�������ĳ���������1)
 * 
 * @author hasee
 *
 */
/*
 * �㷨ʱ�临�Ӷ�O��n�� ��total��¼�ۼ�ֵ��maxSum��¼�����
 * ����˼�룺����һ����A������A������ۼ����Ǹ�����ô����A��ʹ��ֵ��С��A����Ϊ�ۼ�ֵ��
 * ��������й��׵ġ����ǰ�����ۼ�ֵ����������Ϊ�к����ܺͣ�total��¼��ǰֵ�� ��ʱ ���ʹ���maxSum ����maxSum��¼����
 */
public class Solution {
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 0 || array == null)
			return 0;
		int total = array[0];
		int maxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (total >= 0)
				total += array[i];
			else
				total = array[i];
			if (total > maxSum)
				maxSum = total;
		}
		return maxSum;

	}

	public static void main(String[] args) {
		int[] arr = { -1, -2, -3, -10, -4, -7, -2, -5 };
		System.out.println(new Solution().FindGreatestSumOfSubArray(arr));

	}
}
