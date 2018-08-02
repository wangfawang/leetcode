package treeDepth;

import bean.TreeNode;

/**
 * ����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * @author hasee
 *
 */
public class Solution {
	public int TreeDepth(TreeNode root) {
		if(root == null){//ѭ���ݹ����������
            return 0;
        }
		int leftDepth = TreeDepth(root.left);
		int rightDepth = TreeDepth(root.right);
		int maxDepth = Math.max(leftDepth, rightDepth);
		return maxDepth + 1;
	}
}
