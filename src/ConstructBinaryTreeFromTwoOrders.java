/*
	preorder = [3,9,20,15,7]
	inorder = [9,3,15,20,7]
		3
	   / \
	  9  20
	    /  \
	   15   7
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    	if(preStart > preorder.length - 1 || inStart > inEnd) {
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[preStart]);
    	int index = 0;//find the root index in inorder
    	for(int i = inStart; i <= inEnd; i++) {//not < , otherwise will loop forever
    		if(inorder[i] == root.val) {
    			index = i;
    		}
    	}
    	root.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
    	root.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }
}