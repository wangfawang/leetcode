package isBalanceTree;

import bean.TreeNode;

/**
 * 
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 * 
 * ƽ��������Ķ��������������߶Ȳ�С�ڵ���1.
 * 
 * @author hasee
 *
 */
public class Solution {

	private boolean isBalanced = true;

	public boolean IsBalanced_Solution(TreeNode root) {
		isBalanced = true;
		TreeDepth(root);
		return isBalanced;
	}

	public int TreeDepth(TreeNode root) {
		if (root == null) {// ѭ���ݹ����������
			return 0;
		}
		int leftDepth = TreeDepth(root.left);
		int rightDepth = TreeDepth(root.right);
		if (Math.abs(leftDepth - rightDepth) > 1) {
			isBalanced = false;
			return 0;
		}
		int maxDepth = Math.max(leftDepth, rightDepth);
		return maxDepth + 1;
	}
}
