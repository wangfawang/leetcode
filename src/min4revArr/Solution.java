package min4revArr;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
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
		// array[left] >= array[right] 确保旋转
		while (array[left] >= array[right]) {
			// 分界点
			if (right - left == 1) {
				mid = right;
				break;
			} // if
			mid = left + (right - left) / 2;
			// array[left] array[right] array[mid]三者相等
			// 无法确定中间元素是属于前面还是后面的递增子数组
			// 只能顺序查找
			if (array[left] == array[right] && array[left] == array[mid]) {
				return MinOrder(array, left, right);
			} // if
				// 中间元素位于前面的递增子数组
				// 此时最小元素位于中间元素的后面
			if (array[mid] >= array[left]) {
				left = mid;
			} // if
				// 中间元素位于后面的递增子数组
				// 此时最小元素位于中间元素的前面
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
