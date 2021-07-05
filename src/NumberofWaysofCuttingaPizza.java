class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        Integer[][][] dp = new Integer[k][m][n];
        int[][] sufSum = new int[m + 1][n + 1]; // sufSum is the total number of apples in pizza[r:][c:]
        for (int r = m - 1; r >= 0; r--) {
        	for (int c = n - 1; c >= 0; c--) {
        		sufSum[r][c] = sufSum[r][c + 1] + sufSum[r + 1][c] - sufSum[r + 1][c + 1] + (pizza[r].charAt(c) == 'A' ? 1 : 0);
        	}
        }
        return dfs(m, n, k - 1, 0, 0, dp, sufSum);
    }

    int dfs(int m, int n, int k, int r, int c, Integer[][][] dp, int[][] sufSum) {
    	if (sufSum[r][c] == 0) return 0; // no apples left
    	if (k == 0) return 1; // no more cut
    	if (dp[k][r][c] != null) return dp[k][r][c];
    	int res = 0;
    	// cut hor
    	for (int nr = r + 1; nr < m; nr++) {
    		if (sufSum[r][c] - sufSum[nr][c] > 0) {
    			res = (res + dfs(m, n, k - 1, nr, c, dp, sufSum)) % 1000000007;
    		}
    	}
    	// cut ver
    	for (int nc = c + 1; nc < n; nc++) {
    		if (sufSum[r][c] - sufSum[r][nc] > 0) {
    			res = (res + dfs(m, n, k - 1, r, nc, dp, sufSum)) % 1000000007;
    		}
    	}
    	return dp[k][r][c] = res;
    }
}