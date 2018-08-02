package convert;

import bean.TreeNode;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * 
 * @author hasee
 *
 * 
 *         �ݹ�汾 ����˼·�� 1.�������������˫��������������ͷ�ڵ㡣 2.��λ��������˫�������һ���ڵ㡣
 *         3.�������������Ϊ�յĻ�������ǰroot׷�ӵ����������� 4.�������������˫��������������ͷ�ڵ㡣
 *         5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮�� 6.���������������Ƿ�Ϊ��ȷ�����صĽڵ㡣
 *
 */
public class Solution {
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		if (pRootOfTree.left == null && pRootOfTree.right == null)
			return pRootOfTree;
		// 1.�������������˫��������������ͷ�ڵ�
		TreeNode left = Convert(pRootOfTree.left);
		TreeNode leftLast = left;// ������˫�������һ���ڵ�
		// 2.��λ��������˫�������һ���ڵ�
		while (leftLast != null && leftLast.right != null) {
			leftLast = leftLast.right;
		}
		// 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
		if (left != null) {
			leftLast.right = pRootOfTree;
			pRootOfTree.left = leftLast;
		}
		// 4.�������������˫��������������ͷ�ڵ�
		TreeNode right = Convert(pRootOfTree.right);
		// 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
		if (right != null) {
			right.left = pRootOfTree;
			pRootOfTree.right = right;
		}
		return left == null ? pRootOfTree : left;
	}
}
