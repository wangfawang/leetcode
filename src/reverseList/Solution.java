package reverseList;

import bean.ListNode;

/**
 * ����һ��������ת�����������������Ԫ�ء�
 * 
 * @author hasee
 *
 */
public class Solution {
	public ListNode ReverseList(ListNode head) {
		return revLinkedList(head);
	}

	public ListNode revLinkedList(ListNode head) {
		ListNode p1 = head;
		ListNode revHead = new ListNode(0);
		while (p1 != null) {
			ListNode temp = new ListNode(p1.val);
			temp.next = revHead.next;
			revHead.next = temp;
			p1 = p1.next;
		}
		return revHead.next;
	}
}
