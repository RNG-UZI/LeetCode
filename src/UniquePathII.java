class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid[0].length;
        int[] res = new int[len];
        res[0] = 1;
        for(int i = 0; i < obstacleGrid.length; i++) {
        	for(int j = 0; j < obstacleGrid[0].length; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			res[j] = 0;
        		} else if(j > 0){
        			res[j] += res[j - 1];
        		}
        	}
        }
        return res[len - 1];
    }
}