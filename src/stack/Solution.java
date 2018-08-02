package stack;

import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * 
 * @author hasee
 *
 */
public class Solution {
	static Stack<Integer> stack1 = new Stack<>();//��ջ1�洢���е�Ԫ��
	static Stack<Integer> stack2 = new Stack<>();//��ջ2�洢��С��Ԫ����ջ��

	public static void push(int node) {
		stack1.push(node);
		if (stack2.empty()) {
			stack2.push(node);
		} else if (node <= stack2.peek()) {
			stack2.push(node);
		}
	}

	public static void pop() {
		// ���Ҫpop��Ԫ������СԪ�أ���Stack2�д����СԪ��pop��ȥ
		if (stack1.peek() == stack2.peek())
			stack2.pop();
		stack1.pop();
	}

	public static int top() {
		return stack1.peek();
	}

	public static int min() {
		return stack2.peek();
	}

	public static void main(String[] args) {
		push(3);
		System.out.println("min--"+min());
		push(4);
		System.out.println("min--"+min());
		push(2);
		System.out.println("min--"+min());
		push(3);
		System.out.println("min--"+min());
		pop();
		System.out.println("min--"+min());
		pop();
		System.out.println("min--"+min());
		pop();
		System.out.println("min--"+min());
		push(0);
		System.out.println("min--"+min());
	}
}
