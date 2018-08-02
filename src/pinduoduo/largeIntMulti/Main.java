package pinduoduo.largeIntMulti;

import java.util.Scanner;

/**
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。 输入描述: 空格分隔的两个字符串，代表输入的两个大整数
 * 
 * 输出描述: 输入的乘积，用字符串表示
 * 
 * 输入例子1: 72106547548473106236 982161082972751393
 * 
 * 输出例子1: 70820244829634538040848656466105986748
 * 
 * @author hasee
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str1 = sc.next();
			String str2 = sc.next();
			int len1 = str1.length();
			int len2 = str2.length();
			char[] s1 = str1.toCharArray();
			char[] s2 = str2.toCharArray();

			// 反转高低位
			reverse(s1, len1);
			reverse(s2, len2);
			// 两数相乘位数不会大于两数位数和+3
			int[] result = new int[len1 + len2 + 3];
			// 不进位相乘
			for (int j = 0; j < len2; j++) {
				for (int i = 0; i < len1; i++) {
					result[i + j] += Integer.valueOf(String.valueOf(s1[i]))*Integer.valueOf(String.valueOf(s2[j]));
				}
			}
			// 处理进位
			for (int i = 0; i < result.length; i++) {
				int carray = result[i] / 10;
				result[i] = result[i] % 10;
				if (carray > 0) {
					result[i + 1] += carray;
				}
			}
			
			//处理首位的0
			int m = 0;
			for (m = result.length-1; m>=0;) {
				if(result[m]>0)
					break;
				m--;
			}
			
			//打印出乘积结果
			for(int i =0;i<=m;i++){
				System.out.print(result[m-i]);
			}
		}
	}

	public static void reverse(char[] ch, int len) {
		// 高低位对调
		/*
		 * 加减法。 a = a + b; b = a - b; a = a - b;
		 */
		for (int i = 0; i < len / 2; i++) {
			ch[i] = (char) (ch[i] + ch[len - 1 - i]);
			ch[len - 1 - i] = (char) (ch[i] - ch[len - 1 - i]);
			ch[i] = (char) (ch[i] - ch[len - 1 - i]);
		}
	}
}
