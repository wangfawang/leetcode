package merge;

import bean.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author hasee
 *
 */
public class Solution {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode list = new ListNode(0);
		ListNode p = list;
		ListNode p1 = list1;
		ListNode p2 = list2;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p = p.next;
				p1 = p1.next;
			} else {
				p.next = p2;
				p = p.next;
				p2 = p2.next;
			}
		}
		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;
		return list.next;
	}

	public static void main(String[] args) {
		ListNode list1 = ListNode.createLinkedList("125789");
		ListNode.printLinkedList(list1);
		ListNode list2 = ListNode.createLinkedList("0468");
		ListNode.printLinkedList(list2);
		ListNode list = new Solution().Merge(list1, list2);
		ListNode.printLinkedList(list);
	}
}
