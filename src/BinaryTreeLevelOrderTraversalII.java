class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
        	return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	List<Integer> list = new ArrayList<>();
        	for(int i = 0; i < size; i++) {
        		TreeNode cur = queue.poll();
        		if(cur.left != null) {
        			queue.offer(cur.left);
        		}
        		if(cur.right != null) {
        			queue.offer(cur.right);
        		}
        		list.add(cur.val);
        	}
        	res.add(0, list);//add from the beginning
        }
        return res;
    }
}