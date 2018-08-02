package delDuplication;

import bean.ListNode;

/**
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5
 * �����Ϊ 1->2->5
 * 
 * @author hasee
 *
 */

public class Solution {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) { // ֻ��0����1����㣬�򷵻�
			return pHead;
		}
		ListNode pNode = pHead.next;//��ʾ��һ���ڵ�
		if (pHead.val == pNode.val) { // ��ǰ������ظ����
			while (pNode != null && pNode.val == pHead.val) {
				// ����ֵ�뵱ǰ�����ͬ��ȫ�����,�ҵ���һ���뵱ǰ��㲻ͬ�Ľ��
				pNode = pNode.next;
			}
			return deleteDuplication(pNode); // �ӵ�һ���뵱ǰ��㲻ͬ�Ľ�㿪ʼ�ݹ�
		} else { // ��ǰ��㲻���ظ����
			pHead.next = deleteDuplication(pNode); // ������ǰ��㣬����һ����㿪ʼ�ݹ�
		}
		return pHead;
	}

	public static void main(String[] args) {
		ListNode listnode = ListNode.createLinkedList("11123445");
		ListNode newListNode = new Solution().deleteDuplication(listnode);
		ListNode.printLinkedList(newListNode);
	}
}
