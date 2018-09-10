class Solution {
    
    int res = 0;

    public int totalNQueens(int n) {
        //List<List<String>> res = new ArrayList<>();
        if(n <= 0) return res;
        helper(new int[n], 0);
        return res;
    }

    public void helper(int[] queens, int pos) {
    	if(pos == queens.length) {
    		//addSolution(res, queens);
    		res++;
    		return;
    	}
    	for(int i = 0; i < queens.length; i++) {
    		queens[pos] = i;
    		if(isValid(queens, pos)) {
    			helper(queens, pos + 1);
    		}
    	}
    }

    public boolean isValid(int[] queens, int pos) {
    	for(int i = 0; i < pos; i++) {
    		if(queens[i] == queens[pos]) {
    			return false;
    		} else if(Math.abs(queens[pos] - queens[i]) == Math.abs(i - pos)) {//diagonal
    			return false;
    		}
    	}
    	return true;
    }
}