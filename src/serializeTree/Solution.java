package serializeTree;

import bean.TreeNode;

/*
 * 
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 1. 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点
不为空时，在转化val所得的字符之后添加一个' ， '作为分割。对于空节点则以 '#' 代替。
 2. 对于反序列化：按照前序顺序，递归的使用字符串中的字符创建一个二叉树
*/
public class Solution {
	public int index = -1;

	//二叉树的序列化用前序遍历
	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");//空用#表示
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
