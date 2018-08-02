package findPath;

import java.util.ArrayList;

import bean.TreeNode;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * @author hasee
 *
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();// 用来存储所有满足路径
		ArrayList<Integer> path = new ArrayList<Integer>();
		if (root == null)
			return paths;
		dfsFind(root, target, path, paths);
		return paths;
	}

	public void dfsFind(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
		path.add(root.val);
		// 抵达叶子节点
		if (root.left == null && root.right == null) {
			if (root.val == target) {
				paths.add(path);
			}
			return;
		}
		// path2保存进入子树前的path，用于回退后使用
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		path2.addAll(path);
		if (root.left != null)
			// 如果这里传入path2，则会在子树遍历中改变path2的值（只是当前递归的path2），影响右子树的遍历，因为是引用传递，所以能影响形参
			dfsFind(root.left, target - root.val, path, paths);
		if (root.right != null)
			dfsFind(root.right, target - root.val, path2, paths);

	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBiTree("1234537");
		System.out.println(new Solution().FindPath(root, 7));

	}
}
