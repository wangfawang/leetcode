package findKthToTail;

import bean.ListNode;

/**
 * ����һ����������������е�����k����㡣
 * 
 * @author hasee
 *
 */
public class Solution {
	public ListNode FindKthToTail(ListNode head, int k) {
		int index = 1;
		ListNode revHead = revLinkedList(head);
		ListNode.printLinkedList(revHead);
		ListNode p2 = revHead;
		
		while(p2!=null){
			if(index==k){
				break;
			}
			p2 = p2.next;
			index++;
		}
		if(p2==null)//û���ҵ�����p2�������ǿ�
			return null;
		p2.next = null;
		return revLinkedList(revHead);
	}
	
	public ListNode revLinkedList(ListNode head){
		ListNode p1 = head;
		ListNode revHead = new ListNode(0);
		while(p1!=null){
			ListNode temp = new ListNode(p1.val);
			temp.next = revHead.next;
			revHead.next= temp;
			p1 = p1.next;
		}
		return revHead.next;
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.createLinkedList("31");
		ListNode.printLinkedList(head);
		ListNode p = new Solution().FindKthToTail(head, 100);
		ListNode.printLinkedList(p);
	}
}
