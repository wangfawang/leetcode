package entryNodeOfLoop;

import bean.ListNode;

/**
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
 * 
 * @author hasee
 *
 */

/*
 * ����xΪ��ǰ���·�̣���ɫ·�̣���aΪ����ڵ��������·�̣���ɫ·�̣�����˳ʱ���ߣ��� cΪ���ĳ��ȣ���ɫ+��ɫ·�̣�
 * 
 * ������ָ��������ʱ��
 * 
 * ��ʱ��ָ���ߵ�·��ΪSslow = x + m * c + a ��ָ���ߵ�·��ΪSfast = x + n * c + a
 * ���ڼ���fast��slow�������ٶȣ���2 Sslow = Sfast ,2 * ( x + m*c + a ) = (x + n *c + a)
 * �Ӷ������Ƶ����� x = (n - 2 * m )*c - a = (n - 2*m -1 )*c + c - a
 * ������һ������ʱ����ָ������1Ȧ����n=1����ָ��һȦ��û��������m=0�����빫ʽ����x=c-a�� ����ǰ���·�� = �������ĳ��ȣ�Ҳ����Ϊ0�� + c
 * - a ʲô��c -a������������󣬻����沿�ֵ�·�̡�����ɫ·�̣� ���ԣ����ǿ�����һ��ָ������A��ʼ�ߣ���һ��ָ���������B��ʼ���������ߣ�
 * 2��ָ���ٶ�һ������ô������ԭ���ָ���ߵ�����ڵ��ʱ�򣨴�ʱ�պ�����x�� �������㿪ʼ�ߵ��Ǹ�ָ��Ҳһ���պõ��ﻷ��ڵ㡣
 * ����2�߻���������ǡ�������ڻ�����ڵ㡣
 * 
 * ����ж��Ƿ��л������һ����㷨���Ӷ�Ϊ��
 * 
 * ʱ�临�Ӷȣ�O(n) �ռ临�Ӷȣ�O(1)
 */

/*
 * ��һ�����һ������㡣�ֱ���p1��p2ָ������ͷ����p1ÿ����һ����p2ÿ���߶�����ֱ��p1==p2�ҵ��ڻ��е����㡣 �ڶ������һ�����ڡ�
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
			if(pFast == pSlow){//��ʱ�ǵ�һ��������
				//��ڵ��ͷ��ʼ�����ڵ�������㿪ʼ����ͬ�����ٶ�ǰ������һ��������������
				pFast = pHead;
				while(pFast!=pSlow){
					pFast = pFast.next;
					pSlow = pSlow.next;
				}
				//�������ѭ����˵��pFast==pSlow
				return pFast;
			}
		}
		
		//�������whileѭ����˵�����ɻ�
		return null;
	}
}
