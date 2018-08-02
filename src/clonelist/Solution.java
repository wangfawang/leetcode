package clonelist;

import bean.RandomListNode;

/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬
 * ���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * 
 * 
 * ����˼·�� 1��������������ÿ����㣬�縴�ƽ��A�õ�A1�������A1�嵽���A���棻
 * 2�����±������������Ͻ������ָ����½�㣬��A1.random = A.random.next; 3�����������������Ϊԭ����͸��ƺ������
 * 
 * @author hasee
 *
 */
public class Solution {

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null)
			return null;

		RandomListNode currentNode = pHead;
		// 1.����ÿ����㣬�縴�ƽ��A�õ�A1�������A1�嵽���A����
		while (currentNode != null) {
			RandomListNode cloneNode = new RandomListNode(currentNode.label);
			RandomListNode nextNode = currentNode.next;
			currentNode.next = cloneNode;
			cloneNode.next = nextNode;
			currentNode = nextNode;
		}

		// 2.���±������������Ͻ������ָ����½�㣬��A1.random = A.random.next
		currentNode = pHead;
		while (currentNode != null) {
			RandomListNode cloneNode = currentNode.next;
			cloneNode.random = currentNode.random == null ? null : currentNode.random.next;
			currentNode = currentNode.next.next;
		}

		// 3.���������������Ϊԭ����͸��ƺ������
		currentNode = pHead;
		RandomListNode pCloneHead = pHead.next;
		while (currentNode != null) {
			RandomListNode cloneNode = currentNode.next;
			currentNode.next = cloneNode.next;
			cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
			currentNode = currentNode.next;
		}
		return pCloneHead;
	}
}
