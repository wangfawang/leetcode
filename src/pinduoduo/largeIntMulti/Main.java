package pinduoduo.largeIntMulti;

import java.util.Scanner;

/**
 * ���������ַ�����ʾ�ķǳ���Ĵ�����,������ǵĳ˻���Ҳ�����ַ�����ʾ��������ϵͳ�Դ��Ĵ��������͡� ��������: �ո�ָ��������ַ������������������������
 * 
 * �������: ����ĳ˻������ַ�����ʾ
 * 
 * ��������1: 72106547548473106236 982161082972751393
 * 
 * �������1: 70820244829634538040848656466105986748
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

			// ��ת�ߵ�λ
			reverse(s1, len1);
			reverse(s2, len2);
			// �������λ�������������λ����+3
			int[] result = new int[len1 + len2 + 3];
			// ����λ���
			for (int j = 0; j < len2; j++) {
				for (int i = 0; i < len1; i++) {
					result[i + j] += Integer.valueOf(String.valueOf(s1[i]))*Integer.valueOf(String.valueOf(s2[j]));
				}
			}
			// �����λ
			for (int i = 0; i < result.length; i++) {
				int carray = result[i] / 10;
				result[i] = result[i] % 10;
				if (carray > 0) {
					result[i + 1] += carray;
				}
			}
			
			//������λ��0
			int m = 0;
			for (m = result.length-1; m>=0;) {
				if(result[m]>0)
					break;
				m--;
			}
			
			//��ӡ���˻����
			for(int i =0;i<=m;i++){
				System.out.print(result[m-i]);
			}
		}
	}

	public static void reverse(char[] ch, int len) {
		// �ߵ�λ�Ե�
		/*
		 * �Ӽ����� a = a + b; b = a - b; a = a - b;
		 */
		for (int i = 0; i < len / 2; i++) {
			ch[i] = (char) (ch[i] + ch[len - 1 - i]);
			ch[len - 1 - i] = (char) (ch[i] - ch[len - 1 - i]);
			ch[i] = (char) (ch[i] - ch[len - 1 - i]);
		}
	}
}
