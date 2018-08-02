package test1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import twosum.Solution;

public class TwoSum {

	@Test
	public void testTwoSum() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = new Solution().twoSum(nums, target);
		System.out.println(Arrays.toString(result));//Arrays.toString方法可以将数组显示出来
	}

}
