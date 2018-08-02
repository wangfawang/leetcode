package moreThanHalf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * ����n��������������ִ������ڵ������鳤��һ�������
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String[] strs = str.split(" ");
			Integer[] arr = new Integer[strs.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.valueOf(strs[i]);
			}
			System.out.println(moreThanHalf(arr));
		}
	}
	
	
	public static int moreThanHalf(Integer[] arr){
		List<Integer> list = Arrays.asList(arr);
		HashSet<Integer> hs = new HashSet<>(list);//ֱ��ȥ��,set���ϲ����ظ�
		for (Integer i : hs) {
			int count = 0;
			for (int j : list) {
				if(i==j)
					count++;
				if(count>=(arr.length/2))
					return i;
			}
		}
		return 0;
	}
}
