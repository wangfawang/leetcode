package kThNode;

import java.util.ArrayList;

import bean.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 * 
 * @author hasee
 *
 */

/*
 * //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。 // 所以，按照中序遍历顺序找到第k个结点就是结果。
 */
public class Solution {

	int index = 0; // 计数器

	//递归解法O(log2n)
	TreeNode KthNode1(TreeNode root, int k) {
		if (root != null) { // 中序遍历寻找第k个
			TreeNode node = KthNode1(root.left, k);
			if (node != null)
				return node;
			index++;
			if (index == k)
				return root;
			node = KthNode1(root.right, k);
			if (node != null)
				return node;
		}
		return null;
	}

	// O(n)的解法，并不是最优解
	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k == 0)
			return null;
		ArrayList<TreeNode> al = new ArrayList<>();
		midSort(pRoot, al);
		if (al.size() < k)
			return null;
		return al.get(k - 1);
	}

	void midSort(TreeNode pRoot, ArrayList<TreeNode> al) {
		if (pRoot == null) {
			return;
		}
		midSort(pRoot.left, al);
		al.add(pRoot);
		midSort(pRoot.right, al);
	}

	public static void main(String[] args) {
		new Solution().KthNode1(TreeNode.createBiTree("1234567"), 2);
	}
}
