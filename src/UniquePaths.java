class Solution {
    public int uniquePaths(int m, int n) {
    	/*
    	if(m * n == 0 || m < 0 || n < 0) return 0;
    	if(m == 1 && n == 1) return 1;
        if(m > 1) int a = 1 + uniquePaths(m-1, n);
        if(n > 1) int b = 1 + uniquePaths(m, n-1);
        return a + b;
        */
        int[][] res = new int [m][n];
        for(int i = 0;i < m;i++){
        	res[i][0] = 1;
        }
        for(int i = 0;i < n;i++){
        	res[0][i] = 1;
        }
        for(int i = 1;i < m;i++){
        	for(int j = 1;j < n;j++){
        		res[i][j] = res[i-1][j] + res[i][j-1];
        	}
        }
        return res[m-1][n-1];
    }
}