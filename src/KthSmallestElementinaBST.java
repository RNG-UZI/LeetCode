class Solution {
	private int cnt, res;//use inorder
    public int kthSmallest(TreeNode root, int k) {
        if (root.left != null) kthSmallest(root.left, k);
        if (++cnt == k) res = root.val;
        if (root.right != null) kthSmallest(root.right, k);
        return res;
    }
}