package twosum;

/*
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�

ʾ��:
���� nums = [2, 7, 11, 15], target = 9
��Ϊ nums[0] + nums[1] = 2 + 7 = 9
���Է��� [0, 1]
 */
public class Solution {
	public int[] twoSum(int[] nums, int target) {//ʱ�临�Ӷ�O(n^2)
		int[] result = new int[2];
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result = new int[] { i, j };
					return result;
				}
			}
		}
		return result;
	}
}
