package reverseList;

import bean.ListNode;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
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
