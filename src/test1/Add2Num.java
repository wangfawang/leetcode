package test1;

import static org.junit.Assert.*;

import org.junit.Test;

import add2num.Solution;
import bean.ListNode;



public class Add2Num {

	@Test
	public void testAddTwoNumbers() {
		ListNode l1 = new ListNode(1);// l1链表
		ListNode l2 = new ListNode(2);// l2链表
		ListNode p1 = l1;// 遍历结点p1
		ListNode p2 = l2;// 遍历结点p2
		ListNode h1 = new ListNode(0);// 头结点h1
		ListNode h2 = new ListNode(0);// 头结点h2
		h1.next = l1;
		h2.next = l2;

		int i = 1;
		while (p1 != null) {
			p1.next = new ListNode(i);
			p1 = p1.next;
			i += 2;
			if (i == 7) {
				break;
			}
		}
		i = 2;
		while (p2 != null) {
			p2.next = new ListNode(i);
			p2 = p2.next;
			i += 2;
			if (i == 8) {
				break;
			}
		}

		StringBuffer sb = new StringBuffer();
		ListNode p = h1;// 遍历指针
		while (p.next != null) {
			sb.append(p.next.val + "-->");
			p = p.next;
		}
		String str = null;
		if (sb != null) {
			str = sb.substring(0, sb.length() - "-->".length());
		}
		System.out.println(str);
		sb = new StringBuffer();
		p = h2;
		while (p.next != null) {
			sb.append(p.next.val + "-->");
			p = p.next;
		}
		if (sb != null) {
			str = sb.substring(0, sb.length() - "-->".length());
		}
		System.out.println(str);
		ListNode l3 = new Solution().addTwoNumbers(l1, l2);
		ListNode h3 = new ListNode(0);// 结果链头结点
		h3.next = l3;
		p = h3;
		sb = new StringBuffer();
		while (p.next != null) {
			sb.append(p.next.val + "-->");
			p = p.next;
		}
		if (sb != null) {
			str = sb.substring(0, sb.length() - "-->".length());
		}
		System.out.println(str);
	}

}
