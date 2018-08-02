package kThNode;

import java.util.ArrayList;

import bean.TreeNode;

/**
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8�� �У��������ֵ��С˳�����С����ֵΪ4��
 * 
 * @author hasee
 *
 */

/*
 * //˼·�������������������������˳���ӡ�������þ�������õ�˳�� // ���ԣ������������˳���ҵ���k�������ǽ����
 */
public class Solution {

	int index = 0; // ������

	//�ݹ�ⷨO(log2n)
	TreeNode KthNode1(TreeNode root, int k) {
		if (root != null) { // �������Ѱ�ҵ�k��
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

	// O(n)�Ľⷨ�����������Ž�
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
