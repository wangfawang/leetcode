package verifySquenceOfBST;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
 * 
 * @author hasee
 * 
 *         BST�ĺ������еĺϷ������ǣ�����һ������S�����һ��Ԫ����x
 *         ��Ҳ���Ǹ��������ȥ�����һ��Ԫ�ص�����ΪT����ôT���㣺T���Էֳ����Σ�ǰһ�Σ���������С��x����һ�Σ�������������x���������Σ�������
 *         ���ǺϷ��ĺ������С������ĵݹ鶨��
 */
public class Solution {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		if (sequence.length == 1)
			return true;
		return judge(sequence, 0, sequence.length - 1);
	}

	public boolean judge(int[] a, int start, int root) {
		if (start >= root)
			return true;
		int i = root;
		// �ҵ���һ���ȸ��ڵ��С�Ľڵ㣬���������ĸ��ڵ㣬���ұ���������
		while (start < i && a[i - 1] > a[root])
			--i;
		// ��������������нڵ㶼С���������ĸ��������ѭ���������Ϻ������
		for (int j = start; j < i - 1; j++) {
			if (a[j] > a[root])
				return false;
		}
		return judge(a, start, i - 1) && judge(a, i, root - 1);
	}
}
