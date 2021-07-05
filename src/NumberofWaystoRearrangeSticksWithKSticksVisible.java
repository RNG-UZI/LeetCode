class Solution {
	int[][] dp = new int[1001][1001];
	int mod = 1000000007;
    public int rearrangeSticks(int n, int k) {
    	if (k == n) return 1;
        if (k == 0) return 0;
        if (dp[n][k] == 0) {
        	dp[n][k] = (int)((1L * rearrangeSticks(n - 1, k - 1) + 1L * rearrangeSticks(n - 1, k) * (n - 1)) % mod);
        }
        return dp[n][k];
    }
}