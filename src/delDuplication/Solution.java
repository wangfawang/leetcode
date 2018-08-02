package delDuplication;

import bean.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 * 
 * @author hasee
 *
 */

public class Solution {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
			return pHead;
		}
		ListNode pNode = pHead.next;//表示下一个节点
		if (pHead.val == pNode.val) { // 当前结点是重复结点
			while (pNode != null && pNode.val == pHead.val) {
				// 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
				pNode = pNode.next;
			}
			return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
		} else { // 当前结点不是重复结点
			pHead.next = deleteDuplication(pNode); // 保留当前结点，从下一个结点开始递归
		}
		return pHead;
	}

	public static void main(String[] args) {
		ListNode listnode = ListNode.createLinkedList("11123445");
		ListNode newListNode = new Solution().deleteDuplication(listnode);
		ListNode.printLinkedList(newListNode);
	}
}
