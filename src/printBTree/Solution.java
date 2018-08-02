package printBTree;

import java.util.ArrayList;

import bean.TreeNode;

/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
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
