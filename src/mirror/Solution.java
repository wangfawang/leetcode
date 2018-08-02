package mirror;

import bean.TreeNode;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
 * 
 * 
 * �������ľ����壺
 * Դ������ 8
 * 		  / \ 
 *       6  10 
 *      / \ / \ 
 *      5 7 9 11 
 *      ��������� 
 *          8 
 *         / \ 
 *        10  6 
 *       / \ / \ 
 *      11 9 7  5
 * 
 * @author hasee
 *
 */
public class Solution {
	public void Mirror(TreeNode root) {
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			return;
		exchange(root);
		if (root.left != null) {
			Mirror(root.left);
		}
		if (root.right != null) {
			Mirror(root.right);
		}
	}
	
	public void exchange(TreeNode node){
		TreeNode temp = null;
		temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
}
