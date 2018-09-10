class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || (inorder.length != postorder.length) || inorder.length * postorder.length == 0) {
        	return null;
        }
        TreeNode res = helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return res;
    }

    public TreeNode helper(int[] inorder, int[] postorder, 
    	int iStart, int iEnd, int pStart, int pEnd) {
    	if(pStart > pEnd) {
            return null;
        }
        if(pStart == pEnd) {
    		return new TreeNode(postorder[pStart]);
    	} 
    	int rootVal = postorder[pEnd];
    	int idx1 = find(inorder, iStart, iEnd, rootVal);
        /*int idx2 = 0;
        if(idx1 == iStart) {
            idx2 = -1; 
        } else {
        	idx2 = find(postorder, pStart, pEnd, inorder[idx1 - 1]);
        }*/
    	//int idx2 = find(postorder, pStart, pEnd, inorder[idx1 - 1]);
        //System.out.println(idx1);
        //System.out.println(idx2);
    	TreeNode root = new TreeNode(rootVal);
    	TreeNode left = helper(inorder, postorder, iStart, idx1 - 1, pStart, pStart + idx1 - iStart -1);
    	TreeNode right = helper(inorder, postorder, idx1 + 1, iEnd, pStart + idx2 + 1, pEnd - 1);
    	root.left = left;
    	root.right = right;
    	return root;
    }

    public int find(int[] nums, int start, int end, int target) {
    	if(nums == null || nums.length == 0) return -1;
    	for(int i = start; i <= end; i++) {
    		if(nums[i] == target) {
    			return i;
    		}
    	}
    	return -1;
    }
}