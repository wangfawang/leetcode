package findKthToTail;

import bean.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author hasee
 *
 */
public class Solution1 {
	public ListNode FindKthToTail(ListNode head, int k) {
		int count = 0;
		int length = 0;
		ListNode p = head;
		while (p != null) {
			count++;
			p = p.next;
		}
		length = count;
		p = head;
		count = 0;
		while (p != null) {
			if (count == length - k)
				break;
			count++;
			p = p.next;
		}
		return p;
	}
	public static void main(String[] args) {
		ListNode linkedList= ListNode.createLinkedList("13412");
		ListNode.printLinkedList(linkedList);
		ListNode result = new Solution1().FindKthToTail(linkedList, 6);
		ListNode.printLinkedList(result);
	}
}
