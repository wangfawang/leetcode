package bean;

public class TreeNode {
	public int val = 0;
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}

	public static TreeNode createBiTree(String str) {
		int[] arr = new int[str.length()];
		int len = str.length();
		for (int i = 0; i < len; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		
		TreeNode root = new TreeNode(arr[0]);
		root.left = new TreeNode(arr[1]);
		root.right = new TreeNode(arr[2]);
		root.left.left = new TreeNode(arr[3]);
		root.left.right = new TreeNode(arr[4]);
		root.right.left = new TreeNode(arr[5]);
		root.right.right = new TreeNode(arr[6]);
		return root;
	}
}
