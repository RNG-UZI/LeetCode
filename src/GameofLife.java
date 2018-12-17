class Solution {
	//state 0: dead -> dead
	//state 1: live -> live
	//state 2: live -> dead
	//state 3: dead -> live
    public void gameOfLife(int[][] board) {
    	int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    	int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		int cnt = 0;
        		for (int k = 0; k < 8; k++) {
        			int x = i + dx[k], y = j + dy[k];
        			if (x >= 0 && x < row && y >= 0 && y < col && (board[x][y] == 1 || board[x][y] == 2)) {
        				cnt++;
        			}
        		}
        		if (board[i][j] == 1 && (cnt < 2 || cnt > 3)) {
        			board[i][j] = 2;
        		} else if (board[i][j] == 0 && cnt == 3) board[i][j] = 3;
        	}
        }

        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		board[i][j] %= 2;
        	}
        }

    }
}