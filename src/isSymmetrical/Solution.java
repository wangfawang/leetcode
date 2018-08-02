package isSymmetrical;

import bean.TreeNode;

/**
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * 
 * @author hasee
 *
 */
public class Solution {
	boolean isSymmetrical(TreeNode pRoot) {
		TreeNode copy = copyTree(pRoot);
		mirrorTree(pRoot);
		return isSameTree(pRoot, copy);
	}

	// ���������
	void mirrorTree(TreeNode pRoot) {
		if (pRoot == null)
			return;
		// �Ⱦ���������������
		mirrorTree(pRoot.left);
		mirrorTree(pRoot.right);
		// �������Ժ󽻻���������
		TreeNode temp = pRoot.left;
		pRoot.left = pRoot.right;
		pRoot.right = temp;

	}

	// �Ƚ϶�����
	boolean isSameTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		else if (t1 != null && t2 != null && t1.val == t2.val) {// ���ڵ����
			boolean left = isSameTree(t1.left, t2.left);// �ж��������Ƿ����
			boolean right = isSameTree(t1.right, t2.right);// �ж��������Ƿ����
			return left && right;// ֻ��������������ȣ��ŷ���true
		} else
			return false;
	}

	// ���ƶ�����
	TreeNode copyTree(TreeNode pRoot) {
		if (pRoot == null)
			return null;
		TreeNode cpTree = new TreeNode(pRoot.val);// ���Ƹ��ڵ�
		cpTree.left = copyTree(pRoot.left);// ���ƽڵ��������Ϊ���ƺ��������
		cpTree.right = copyTree(pRoot.right);// ���ƽڵ��������Ϊ���ƺ��������
		return cpTree;
	}
}
