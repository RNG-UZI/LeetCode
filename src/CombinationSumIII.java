class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, new ArrayList(), 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int start, int n, int k) {
    	if(path.size() == k) {
    		if(n == 0) res.add(new ArrayList(path));
    		return;
    	}
    	for(int i = start; i <= 9; i++) {
    		path.add(i);
    		dfs(res, path, i+1, n-i, k);
    		path.remove(path.size() - 1);
    	}
    }
}