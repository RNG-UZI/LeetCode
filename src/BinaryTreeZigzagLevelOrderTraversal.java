class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode cur, int level) {
    	if(cur == null) return;
    	if(res.size() <= level) {
    		List<Integer> newLevel = new ArrayList<>();
    		res.add(newLevel);
    	}
    	List<Integer> p = res.get(level);
    	if(level % 2 == 0) p.add(cur.val);
    	else p.add(0, cur.val);
    	helper(res, cur.left, level + 1);
    	helper(res, cur.right, level + 1);
    }
}