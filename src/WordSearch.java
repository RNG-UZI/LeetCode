class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(helper(board, i, j, word, 0)){
        			return true;
        		}
        	}
        }
        return false;
    }

    public boolean helper(char[][] board, int i, int j, String word, int start) {
    	if(start >= word.length()) {
    		return true;
    	}
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
    		return false;
    	}
    	if(board[i][j] == word.charAt(start++)) {
    		char c = board[i][j];
    		board[i][j] = '#';
    		boolean res = helper(board, i + 1, j, word, start) ||
    					helper(board, i - 1, j, word, start) ||
    					helper(board, i, j + 1, word, start) ||
    					helper(board, i, j - 1, word, start);
    		board[i][j] = c;
    		return res;
    	}
    	return false;
    }
}