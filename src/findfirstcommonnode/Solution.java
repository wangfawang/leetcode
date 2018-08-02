package findfirstcommonnode;

import java.util.HashSet;

import bean.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走 （因为2个链表用公共的尾部）,Y型
 * 
 * @author hasee
 *
 */
public class Solution {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode current1 = pHead1;
		ListNode current2 = pHead2;
		HashSet<ListNode> hashSet = new HashSet<>();
		while (current1 != null) {
			hashSet.add(current1);
			current1 = current1.next;
		}
		while (current2 != null) {
			if (hashSet.contains(current2))
				return current2;
			current2 = current2.next;
		}
		return null;
	}
}
