package sort;

public class ArrayUtil {
	public static void printArray(int[] arr) {
		StringBuilder sb = new StringBuilder();
		String res = null;
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ",");
		}
		if (sb.length() != 0)
			res = sb.substring(0, sb.length() - ",".length());
		System.out.println(res);
	}
}
