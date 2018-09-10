class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
        	return res;
        }
        helper(res, root);
        return res;
    }
    public static void helper(List<Integer> res, TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	helper(res, root.left);
    	res.add(root.val);
    	helper(res, root.right);
    }
}