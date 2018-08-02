package add2num;

import bean.ListNode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * 
 */
public class Solution {

	

	/**
	 * 002-Add Two Numbers (单链表表示的两个数相加)
	 * 
	 * @param l1
	 *            第一个数
	 * @param l2
	 *            第二个数
	 * @return 结果
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode p1 = l1;// p1的遍历指针
		ListNode p2 = l2;// p2的遍历指针
		ListNode root = new ListNode(0); // 头结点
		ListNode r = root;// 结果链的遍历指针
		root.next = l1;

		int carry = 0; // 初始进位
		int sum;
		while (p1 != null && p2 != null) {
			sum = p1.val + p2.val + carry;
			p1.val = sum % 10; // 本位的结果
			carry = sum / 10; // 本次进位

			r.next = p1;
			r = p1; // 指向后一个相加的结点
			p1 = p1.next;
			p2 = p2.next;

		}

		if (p1 == null) {
			r.next = p2;
		} else {
			r.next = p1;
		}

		// 最后一次相加还有进位
		if (carry == 1) {
			// 开始时r.next是第一个要相加的结点
			while (r.next != null) {
				sum = r.next.val + carry;
				r.next.val = sum % 10;
				carry = sum / 10;
				r = r.next;
			}

			// 都加完了还有进位，就要创建一个新的结点
			if (carry == 1) {
				r.next = new ListNode(1);
			}
		}

		return root.next;
	}

}
