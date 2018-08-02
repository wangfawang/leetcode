package findfirstcommonnode;

import java.util.HashSet;

import bean.ListNode;

/**
 * �������������ҳ����ǵĵ�һ��������㡣
 * 
 * �ҳ�2������ĳ��ȣ�Ȼ���ó���������������ĳ��ȲȻ����һ���� ����Ϊ2�������ù�����β����,Y��
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
