class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        int len = triangle.size();
        int[] dp = new int[len];
        for(int i = 0; i < len; i++) {
        	dp[i] = triangle.get(len - 1).get(i);
        }
        for(int i = len - 2; i >= 0; i--) {
        	List<Integer> row = triangle.get(i);
        	for(int j = 0; j < row.size(); j++) {
        		dp[j] = row.get(j) + Math.min(dp[j], dp[j + 1]);
        	}
        }
        return dp[0];
    }
}