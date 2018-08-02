package serializeTree;

import bean.TreeNode;

/*
 * 
 * ��ʵ�������������ֱ��������л��ͷ����л�������
 * 
 1. �������л���ʹ��ǰ��������ݹ�Ľ���������ֵת��Ϊ�ַ���������ÿ�ζ������Ľ��
��Ϊ��ʱ����ת��val���õ��ַ�֮�����һ��' �� '��Ϊ�ָ���ڿսڵ����� '#' ���档
 2. ���ڷ����л�������ǰ��˳�򣬵ݹ��ʹ���ַ����е��ַ�����һ��������
*/
public class Solution {
	public int index = -1;

	//�����������л���ǰ�����
	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");//����#��ʾ
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();

	}

	TreeNode Deserialize(String str) {
		index++;
		if (index >= str.length())
			return null;
		String[] strr = str.split(",");	
		TreeNode node = null;
		if (!strr[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(strr[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
}
