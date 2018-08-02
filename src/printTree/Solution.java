package printTree;

import java.util.ArrayList;
import java.util.LinkedList;

import bean.TreeNode;

/**
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 * 
 * @author hasee
 *
 */
public class Solution {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		int layer = 1;
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

		// ��ΪҪÿ��ÿ����룬����Ҫ���С�����������ģ����У������ڵ㣬Ƶ�������Ӽ��٣�Ӧ��ʹ���������������Ա�
		LinkedList<TreeNode> odd = new LinkedList<>();// ������
		LinkedList<TreeNode> even = new LinkedList<>();// ż����
		odd.offer(pRoot);
		while (!odd.isEmpty() || !even.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<>();
			if (layer % 2 != 0) {
				while (!odd.isEmpty()) {// ������������ڵ㣬����ż�������ڵ�
					TreeNode node = odd.poll();
					if (node != null) {
						temp.add(node.val);
						even.offer(node.left);
						even.offer(node.right);
					}
				}
				if (!temp.isEmpty()) {
					al.add(temp);
					layer++;
				}
			} else {
				while (!even.isEmpty()) {// ���ż�������ڵ㣬�������������ڵ�
					TreeNode node = even.poll();
					if (node != null) {
						temp.add(node.val);
						odd.offer(node.left);
						odd.offer(node.right);
					}
				}
				if (!temp.isEmpty()) {
					al.add(temp);
					layer++;
				}
			}
		}
		return al;
	}
}
