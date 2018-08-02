package entryNodeOfLoop;

import bean.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 
 * @author hasee
 *
 */

/*
 * 假设x为环前面的路程（黑色路程），a为环入口到相遇点的路程（蓝色路程，假设顺时针走）， c为环的长度（蓝色+橙色路程）
 * 
 * 当快慢指针相遇的时候：
 * 
 * 此时慢指针走的路程为Sslow = x + m * c + a 快指针走的路程为Sfast = x + n * c + a
 * 现在假设fast是slow的两倍速度，则2 Sslow = Sfast ,2 * ( x + m*c + a ) = (x + n *c + a)
 * 从而可以推导出： x = (n - 2 * m )*c - a = (n - 2*m -1 )*c + c - a
 * ，当第一次相遇时，快指针走了1圈所以n=1，慢指针一圈还没走完所以m=0，代入公式则有x=c-a。 即环前面的路程 = 数个环的长度（也可能为0） + c
 * - a 什么是c -a？这是相遇点后，环后面部分的路程。（橙色路程） 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，
 * 2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x） 从相遇点开始走的那个指针也一定刚好到达环入口点。
 * 所以2者会相遇，且恰好相遇在环的入口点。
 * 
 * 最后，判断是否有环，且找环的算法复杂度为：
 * 
 * 时间复杂度：O(n) 空间复杂度：O(1)
 */

/*
 * 第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。 第二步，找环的入口。
 */
public class Solution {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null)
			return null;
		ListNode pFast = pHead;
		ListNode pSlow = pHead;
		while (pFast.next != null) {
			pFast = pFast.next.next;
			pSlow = pSlow.next;
			if(pFast == pSlow){//此时是第一次相遇点
				//快节点从头开始，慢节点从相遇点开始，用同样的速度前进，下一个相遇点就是入口
				pFast = pHead;
				while(pFast!=pSlow){
					pFast = pFast.next;
					pSlow = pSlow.next;
				}
				//如果跳出循环则说明pFast==pSlow
				return pFast;
			}
		}
		
		//如果跳出while循环，说明不成环
		return null;
	}
}
