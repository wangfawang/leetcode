package treeDepth;

import bean.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author hasee
 *
 */
public class Solution {
	public int TreeDepth(TreeNode root) {
		if(root == null){//循环递归的跳出条件
            return 0;
        }
		int leftDepth = TreeDepth(root.left);
		int rightDepth = TreeDepth(root.right);
		int maxDepth = Math.max(leftDepth, rightDepth);
		return maxDepth + 1;
	}
}
