class Solution {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 1; ++i) {
        	for (int j = i + 1; j < grid.length; ++j) {
        		int cnt = 0;
        		for (int k = 0; k < grid[0].length; ++k) {
        			if (grid[i][k] == 1 && grid[j][k] == 1) {
        				cnt++;
        			}
        		}
                if (cnt > 0) {
                    res += cnt * (cnt - 1) / 2;
                }
        	}
        }
        return res;
    }
}