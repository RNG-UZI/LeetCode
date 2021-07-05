/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
	private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static final char[] FORWARD = {'U', 'D', 'L', 'R'};
	private static final char[] BACKWARD = {'D', 'U', 'R', 'L'};
	private static final int UNVISITED = 0;
	private static final int PATH = 1;
	private static final int TARGET = 2;
	private static final int BLOCK = -1;

    public int findShortestPath(GridMaster master) {
        int N = 500;
        int[][] grid = new int[N * 2][N * 2];
        // use dfs first
        dfs(N, N, master, grid);
        // bfs
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, N});
        grid[N][N] = BLOCK;
        int res = 0;
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	while (size-- > 0) {
        		int[] cur = queue.poll();
        		for (int i = 0; i < 4; i++) {
        			int p = cur[0] + DIRS[i][0];
        			int q = cur[1] + DIRS[i][1];
        			if (grid[p][q] == TARGET) {
        				return res + 1;
        			}
        			if (grid[p][q] == BLOCK) {
        				continue;
        			}
        			queue.offer(new int[]{p, q});
        			grid[p][q] = BLOCK;
        		}
        	}
        	res++;
        }
        return -1;
    }

    private void dfs(int r, int c, GridMaster master, int[][] grid) {
    	if (grid[r][c] != UNVISITED) return;
    	if (master.isTarget()) {
    		grid[r][c] = TARGET;
    	} else {
    		grid[r][c] = PATH;
    	}
    	for (int i = 0; i < 4; i++) {
    		char forward = FORWARD[i];
    		char backward = BACKWARD[i];
    		int p = r + DIRS[i][0];
    		int q = c + DIRS[i][1];
    		if (!master.canMove(forward)) {
    			grid[p][q] = BLOCK;
    		} else {
    			master.move(forward);
    			dfs(p, q, master, grid);
    			master.move(backward);
    		}
    	}
    }
}