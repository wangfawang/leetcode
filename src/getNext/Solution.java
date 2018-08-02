package getNext;

import bean.TreeLinkNode;

/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
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
	 * ��1�� ���ýڵ����������������һ���ڵ�Ϊ�����������ӽڵ㣨��ͼ�ڵ� B ��
	 * 
	 * ��2�� ���ýڵ㲻������������
	 * 
	 * �����ĸ��ڵ�ĸ��ڵ�ĸ��ڵ�...ֱ����ǰ������丸�ڵ������λ�ã���I�������û��eg��G����ô������β�ڵ㡣
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
		// �������������������һ���ڵ�Ϊ�����������ӽڵ�
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		} else {// ���������������
				// �����ĸ��ڵ�ĸ��ڵ�ĸ��ڵ�...ֱ����ǰ������丸�ڵ������λ��
			while (pNode.next != null) {// ��pNode���Ǹ��ڵ�ʱ
				if (pNode.next.left == pNode) {
					return pNode.next;
				}
				pNode = pNode.next;
			}
			// ����Ǹ��ڵ㣬�򷵻�null
			return null;
		}
	}

}
