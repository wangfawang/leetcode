package bean;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.val);
	}

	public static ListNode createLinkedList(String str) {
		int temp;
		ListNode head = new ListNode(0);
		ListNode p = head;
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i) - '0';
			p.next = new ListNode(temp);
			p = p.next;
		}
		return head.next;
	}

	public static void printLinkedList(ListNode head) {
		StringBuffer sb = new StringBuffer();
		ListNode p = head;// ±éÀúÓÎ±ê
		while (p != null) {
			sb.append(p.val + "-->");
			p = p.next;
		}
		String str = null;
		if (sb.length() != 0) {
			str = sb.substring(0, sb.length() - "-->".length());
		}
		System.out.println(str);
	}
	
	public static ListNode revLinkedList(ListNode head){
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
}
