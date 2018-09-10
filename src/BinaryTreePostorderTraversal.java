class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {// left right root
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	if (root.left == null && root.right == null) {
    		res.add(root.val);
    		return;
    	}
    	helper(res, root.left);
    	helper(res, root.right);
    	res.add(root.val);
    }
}