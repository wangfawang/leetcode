package printBTree;

import java.util.ArrayList;

import bean.TreeNode;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * @author hasee
 *
 */
public class Solution {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<TreeNode> queue = new ArrayList<>();
		ArrayList<Integer> al = new ArrayList<>();
		if (root == null)
			return al;
		queue.add(root);
		while (queue.size() != 0) {
			TreeNode temp = queue.remove(0);
			if (temp.left != null) 	
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
			al.add(temp.val);
		}

		return al;
	}
}
