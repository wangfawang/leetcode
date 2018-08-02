package stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * @author hasee
 *
 */
public class Solution {
	static Stack<Integer> stack1 = new Stack<>();//用栈1存储所有的元素
	static Stack<Integer> stack2 = new Stack<>();//用栈2存储最小的元素在栈顶

	public static void push(int node) {
		stack1.push(node);
		if (stack2.empty()) {
			stack2.push(node);
		} else if (node <= stack2.peek()) {
			stack2.push(node);
		}
	}

	public static void pop() {
		// 如果要pop的元素是最小元素，则将Stack2中存的最小元素pop出去
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
