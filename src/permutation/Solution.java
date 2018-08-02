package permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,
 * bca,cab��cba��
 * 
 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ;;
 * 
 * @author hasee
 *
 */
public class Solution {
	public static void main(String[] args) {
		Solution p = new Solution();
		System.out.println(p.Permutation("abc").toString());
	}

	public ArrayList<String> Permutation(String str) {
		List<String> res = new ArrayList<>();
		if (str != null && str.length() > 0) {
			PermutationHelper(str.toCharArray(), 0, res);
			Collections.sort(res);// ��ȫ������������
		}
		return (ArrayList) res;
	}

	/*
	 * �ȹ̶�ԭ�ַ������ٴӺ���ǰ�̶����Ӻ���ǰ�������õ�ȫ��������.(���ݷ�)
	 */
	public void PermutationHelper(char[] cs, int i, List<String> list) {
		if (i == cs.length - 1) {
			String val = String.valueOf(cs);
			if (!list.contains(val))
				list.add(val);
		} else {
			for (int j = i; j < cs.length; j++) {// i��ʾ�Ѿ��̶�����
				swap(cs, i, j);// ���������λ�ã������ݹ�
				PermutationHelper(cs, i + 1, list);
				swap(cs, i, j);// �ݹ����Ժ󣬻ָ�֮ǰ��˳��
			}
		}
	}

	public void swap(char[] cs, int i, int j) {
		char tmp = cs[i];
		cs[i] = cs[j];
		cs[j] = tmp;
	}
}
