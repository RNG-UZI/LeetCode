class Solution {

	private int maxCnt = 0, curVal, curCnt = 0;
	private List<Integer> list;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        curVal = root.val;
        list = new ArrayList<>();
        inOrderCount(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	res[i] = list.get(i);
        }
        return res;
    }

    //bst and inorder equals a sorted array
    private void inOrderCount(TreeNode node) {
    	if (node == null) return;
    	inOrderCount(node.left);
    	if (node.val == curVal) {
    		curCnt++;
    	} else {
    		curVal = node.val;
    		curCnt = 1;
    	}

    	if (curCnt == maxCnt) {
    		list.add(node.val);
    	} else if (curCnt > maxCnt) {
    		maxCnt = curCnt;
    		list.clear();
    		list.add(node.val);
    	}
    	inOrderCount(node.right);
    }
}