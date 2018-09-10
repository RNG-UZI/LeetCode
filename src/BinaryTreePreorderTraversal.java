class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {// root left right
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
    	res.add(root.val);
    	helper(res, root.left);
    	helper(res, root.right);
    }
}