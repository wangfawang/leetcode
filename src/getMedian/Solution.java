package getMedian;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 * @author hasee
 *
 */
public class Solution {
	ArrayList<Integer> al = new ArrayList<>();

	public void Insert(Integer num) {
		al.add(num);

	}

	public Double GetMedian() {
		Collections.sort(al);
		int size = al.size();
		if (size % 2 != 0) {// 奇数个
			return (double) (al.get((0 + size - 1) / 2));
		} else {// 偶数个
			int num1 = al.get(size / 2);
			int num2 = al.get(size / 2 - 1);
			return (double) (num1 + num2) / 2;

		}
	}

}
