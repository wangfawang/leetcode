package findfirstcommonnode;

import bean.ListNode;

public class Solution1 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode cur1 = pHead1;
		ListNode cur2 = pHead2;

		int len1 = getListNodeLen(cur1);
		int len2 = getListNodeLen(cur2);

		if (len1 >= len2) {
			int len = len1 - len2;
			while (len > 0) {
				cur1 = cur1.next;
				len--;
			}
		} else {
			int len = len2 - len1;
			while (len > 0) {
				cur2 = cur2.next;
				len--;
			}
		}

		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	private int getListNodeLen(ListNode node) {
		int len = 0;
		ListNode cur = node;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}
}
