class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int min, int max) {
    	List<TreeNode> res  = new ArrayList<>();
    	if(min > max) return res;
    	for(int rt = min; rt <= max; rt++) {
    		List<TreeNode> left = helper(min, rt - 1);
    		List<TreeNode> right = helper(rt + 1, max);
    		if(left.size() == 0 && right.size() == 0) {
    			TreeNode root = new TreeNode(rt);
    			res.add(root);
    		} else if(left.size() == 0) {
    			//TreeNode root = new TreeNode(rt);
    			for(TreeNode r: right) {
    				TreeNode root = new TreeNode(rt);
    				root.right = r;
    				res.add(root);
    			}
    		} else if(right.size() == 0) {
    			for(TreeNode l: left) {
    				TreeNode root = new TreeNode(rt);
    				root.left = l;
    				res.add(root);
    			}
    		} else {
    			for(TreeNode l: left) {
    				for(TreeNode r: right) {
    					TreeNode root = new TreeNode(rt);
    					root.left = l;
    					root.right = r;
    					res.add(root);
    				}
    			}
    		}
    	}
    	return res;
    }
}