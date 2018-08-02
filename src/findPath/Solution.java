package findPath;

import java.util.ArrayList;

import bean.TreeNode;

/**
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * 
 * @author hasee
 *
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();// �����洢��������·��
		ArrayList<Integer> path = new ArrayList<Integer>();
		if (root == null)
			return paths;
		dfsFind(root, target, path, paths);
		return paths;
	}

	public void dfsFind(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
		path.add(root.val);
		// �ִ�Ҷ�ӽڵ�
		if (root.left == null && root.right == null) {
			if (root.val == target) {
				paths.add(path);
			}
			return;
		}
		// path2�����������ǰ��path�����ڻ��˺�ʹ��
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		path2.addAll(path);
		if (root.left != null)
			// ������ﴫ��path2����������������иı�path2��ֵ��ֻ�ǵ�ǰ�ݹ��path2����Ӱ���������ı�������Ϊ�����ô��ݣ�������Ӱ���β�
			dfsFind(root.left, target - root.val, path, paths);
		if (root.right != null)
			dfsFind(root.right, target - root.val, path2, paths);

	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBiTree("1234537");
		System.out.println(new Solution().FindPath(root, 7));

	}
}
