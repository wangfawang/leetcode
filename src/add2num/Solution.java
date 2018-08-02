package add2num;

import bean.ListNode;

/**
 * ���������ǿ���������ʾ�����Ǹ�������λ����������ʽ�洢�����ǵ�ÿ���ڵ�ֻ�洢�������֡���������ӷ���һ���µ�����
 * 
 * ����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��
 * 
 * ʾ����
 * 
 * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4) �����7 -> 0 -> 8 ԭ��342 + 465 = 807
 * 
 * 
 */
public class Solution {

	

	/**
	 * 002-Add Two Numbers (�������ʾ�����������)
	 * 
	 * @param l1
	 *            ��һ����
	 * @param l2
	 *            �ڶ�����
	 * @return ���
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode p1 = l1;// p1�ı���ָ��
		ListNode p2 = l2;// p2�ı���ָ��
		ListNode root = new ListNode(0); // ͷ���
		ListNode r = root;// ������ı���ָ��
		root.next = l1;

		int carry = 0; // ��ʼ��λ
		int sum;
		while (p1 != null && p2 != null) {
			sum = p1.val + p2.val + carry;
			p1.val = sum % 10; // ��λ�Ľ��
			carry = sum / 10; // ���ν�λ

			r.next = p1;
			r = p1; // ָ���һ����ӵĽ��
			p1 = p1.next;
			p2 = p2.next;

		}

		if (p1 == null) {
			r.next = p2;
		} else {
			r.next = p1;
		}

		// ���һ����ӻ��н�λ
		if (carry == 1) {
			// ��ʼʱr.next�ǵ�һ��Ҫ��ӵĽ��
			while (r.next != null) {
				sum = r.next.val + carry;
				r.next.val = sum % 10;
				carry = sum / 10;
				r = r.next;
			}

			// �������˻��н�λ����Ҫ����һ���µĽ��
			if (carry == 1) {
				r.next = new ListNode(1);
			}
		}

		return root.next;
	}

}
