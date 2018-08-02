package lastRemaining;

import java.util.LinkedList;

/**
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:����,
 * ��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,
 * ���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�
 * ����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 * 
 * @author hasee
 *
 */
public class Solution {
	public int LastRemaining_Solution(int n, int m) {
		if (m == 0 || n == 0) {
			return -1;
		}
		LinkedList<Integer> data = new LinkedList<>();// ��Ϊ�漰��ɾ����������linkedList����
		for (int i = 0; i < n; i++) {
			data.add(i);
		}
		int index = -1;
		while (data.size() > 1) {
			index = (index + m) % data.size();
			data.remove(index);
			index--;
		}
		return data.get(0);
	}
}
