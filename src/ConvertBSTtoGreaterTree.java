class Solution {
    
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode cur) {
    	if(cur == null) {
    		return;
    	}
    	helper(cur.right);
    	cur.val += sum;
    	sum = cur.val;
    	helper(cur.left);
    }
}