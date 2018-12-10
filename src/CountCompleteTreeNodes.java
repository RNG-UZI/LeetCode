class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = 0;
        TreeNode left = root;
        while (left != null) {
        	leftDepth++;
        	left = left.left;
        }
        int rightDepth = 0;
        TreeNode right = root;
        while (right != null) {
        	rightDepth++;
        	right = right.right;
        }
        if (leftDepth == rightDepth) return (int)Math.pow(2, leftDepth) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}