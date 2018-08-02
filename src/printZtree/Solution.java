package printZtree;

import java.util.ArrayList;
import java.util.Stack;

import bean.TreeNode;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author hasee
 *
 */
public class Solution {

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		int layer = 1;// 层数
		Stack<TreeNode> s1 = new Stack<>();// 存奇数层
		Stack<TreeNode> s2 = new Stack<>();// 存偶数层
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		s1.push(pRoot);
		while (!s1.empty() || !s2.empty()) {
			ArrayList<Integer> temp = new ArrayList<>();
			if (layer % 2 != 0) {// 奇数层,打印从左向右，即数组链表顺序左到右存入
				while (!s1.empty()) {
					TreeNode node = s1.pop();
					if (node != null) {
						temp.add(node.val);
						// 奇数层的孩子是偶数层，偶数层从左向右入栈，出栈则从右向左存入数组链表
						s2.push(node.left);
						s2.push(node.right);
					}			
				}
				if (!temp.isEmpty()) {
					al.add(temp);
					layer++;
				}
			} else {// 偶数层,打印从右向左，即数组链表顺序右到左存入
				while (!s2.empty()) {
					TreeNode node = s2.pop();
					if (node != null) {
						temp.add(node.val);
						// 偶数层的孩子是奇数层，奇数层从右向左入栈，出栈则从左向右存入数组链表
						s1.push(node.right);
						s1.push(node.left);
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
