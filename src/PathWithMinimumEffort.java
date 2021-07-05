class Solution {
	private int[] d = {0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] efforts = new int[m][n];
        for (int[] e: efforts) {
        	Arrays.fill(e, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[3]);
        while (!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	int effort = cur[0], x = cur[1], y = cur[2];
        	if (x == m - 1 && y == n - 1) {
        		return effort;
        	}
        	for (int i = 0; i < 4; i++) {
        		int row = x + d[i], col = y + d[i + 1];
        		if (row >= 0 && row < m && col >= 0 && col < n) {
        			int nextEffort = Math.max(effort, Math.abs(heights[row][col] - heights[x][y]));
	        		if (nextEffort < efforts[row][col]) {
	        			efforts[row][col] = nextEffort;
	        			pq.offer(new int[]{nextEffort, row, col});
	        		}
        		}
        	}
        }
        return -1;
    }
}