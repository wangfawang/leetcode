package printTree;

import java.util.ArrayList;
import java.util.LinkedList;

import bean.TreeNode;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * @author hasee
 *
 */
public class Solution {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		int layer = 1;
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

		// 因为要每层每层存入，所以要分行。用数组链表模拟队列，存树节点，频繁的增加减少，应该使用链表，而不是线性表
		LinkedList<TreeNode> odd = new LinkedList<>();// 奇数行
		LinkedList<TreeNode> even = new LinkedList<>();// 偶数行
		odd.offer(pRoot);
		while (!odd.isEmpty() || !even.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<>();
			if (layer % 2 != 0) {
				while (!odd.isEmpty()) {// 输出奇数层树节点，存入偶数层树节点
					TreeNode node = odd.poll();
					if (node != null) {
						temp.add(node.val);
						even.offer(node.left);
						even.offer(node.right);
					}
				}
				if (!temp.isEmpty()) {
					al.add(temp);
					layer++;
				}
			} else {
				while (!even.isEmpty()) {// 输出偶数层树节点，存入奇数层树节点
					TreeNode node = even.poll();
					if (node != null) {
						temp.add(node.val);
						odd.offer(node.left);
						odd.offer(node.right);
					}
				}
				if (!temp.isEmpty()) {
					al.add(temp);
					layer++;
				}
			}
		}
		return al;
	}
}
