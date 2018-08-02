package isSymmetrical;

import bean.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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

	// 镜像二叉树
	void mirrorTree(TreeNode pRoot) {
		if (pRoot == null)
			return;
		// 先镜像它的左右子树
		mirrorTree(pRoot.left);
		mirrorTree(pRoot.right);
		// 镜像完以后交换左右子树
		TreeNode temp = pRoot.left;
		pRoot.left = pRoot.right;
		pRoot.right = temp;

	}

	// 比较二叉树
	boolean isSameTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		else if (t1 != null && t2 != null && t1.val == t2.val) {// 父节点相等
			boolean left = isSameTree(t1.left, t2.left);// 判断左子树是否相等
			boolean right = isSameTree(t1.right, t2.right);// 判断左子树是否相等
			return left && right;// 只有左右子树都相等，才返回true
		} else
			return false;
	}

	// 复制二叉树
	TreeNode copyTree(TreeNode pRoot) {
		if (pRoot == null)
			return null;
		TreeNode cpTree = new TreeNode(pRoot.val);// 复制父节点
		cpTree.left = copyTree(pRoot.left);// 复制节点的左子树为复制后的左子树
		cpTree.right = copyTree(pRoot.right);// 复制节点的右子树为复制后的右子树
		return cpTree;
	}
}
