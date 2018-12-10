class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        int[][] dpi = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
        	for (int j = 1; j <= col; j++) {
        		if (matrix[i - 1][j - 1] == '1') {
        			dpi[i][j] = Math.min(dpi[i - 1][j - 1], Math.min(dpi[i - 1][j], dpi[i][j - 1])) + 1;
        			if (dpi[i][j] > res) {
        				res = dpi[i][j];
        			}
        		}
        	}
        }
        return res * res;
    }
}