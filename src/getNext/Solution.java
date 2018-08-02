package getNext;

import bean.TreeLinkNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 * @author hasee
 *
 */
public class Solution {

	/*
	 * -----------------A
	 * 
	 * 
	 * ------------B---------C
	 * 
	 * 
	 * -------D------E----F---------G
	 * 
	 * 
	 * 
	 * ----------H-----I
	 * 
	 * 
	 * （1） 若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点 B ）
	 * 
	 * （2） 若该节点不存在右子树：
	 * 
	 * 找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置（如I）。如果没有eg：G，那么他就是尾节点。
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
		// 如果存在右子树，则下一个节点为右子树最左子节点
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		} else {// 如果不存在右子树
				// 找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置
			while (pNode.next != null) {// 当pNode不是根节点时
				if (pNode.next.left == pNode) {
					return pNode.next;
				}
				pNode = pNode.next;
			}
			// 如果是根节点，则返回null
			return null;
		}
	}

}
