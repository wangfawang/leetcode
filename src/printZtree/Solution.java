package printZtree;

import java.util.ArrayList;
import java.util.Stack;

import bean.TreeNode;

/**
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * 
 * @author hasee
 *
 */
public class Solution {

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		int layer = 1;// ����
		Stack<TreeNode> s1 = new Stack<>();// ��������
		Stack<TreeNode> s2 = new Stack<>();// ��ż����
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		s1.push(pRoot);
		while (!s1.empty() || !s2.empty()) {
			ArrayList<Integer> temp = new ArrayList<>();
			if (layer % 2 != 0) {// ������,��ӡ�������ң�����������˳�����Ҵ���
				while (!s1.empty()) {
					TreeNode node = s1.pop();
					if (node != null) {
						temp.add(node.val);
						// ������ĺ�����ż���㣬ż�������������ջ����ջ��������������������
						s2.push(node.left);
						s2.push(node.right);
					}			
				}
				if (!temp.isEmpty()) {
					al.add(temp);
					layer++;
				}
			} else {// ż����,��ӡ�������󣬼���������˳���ҵ������
				while (!s2.empty()) {
					TreeNode node = s2.pop();
					if (node != null) {
						temp.add(node.val);
						// ż����ĺ����������㣬���������������ջ����ջ��������Ҵ�����������
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
