class Solution {
    public int twoEggDrop(int n) {
        int[][] dp = new int[3][n + 1];
        for (int i = 1; i <= n; i++) {
        	dp[1][i] = i;
        }
        dp[2][1] = 1;
        for (int i = 2; i <= n; i++) {
        	int bestPolicy = Integer.MAX_VALUE;
        	for (int k = 1; k <= i; k++) {
        		int eggBreak = dp[1][k];
        		int eggNotBreak = dp[2][i - k];
        		bestPolicy = Math.min(bestPolicy, Math.max(eggBreak, eggNotBreak));
        	}
        	dp[2][i] = 1 + bestPolicy;
        }
        return dp[2][n];
    }
}