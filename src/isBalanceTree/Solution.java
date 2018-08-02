package isBalanceTree;

import bean.TreeNode;

/**
 * 
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * 平衡二叉树的定义是左右子树高度差小于等于1.
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
		if (root == null) {// 循环递归的跳出条件
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
