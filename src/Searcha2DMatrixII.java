class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        //search from top right to bottom left
        while (col >= 0 && row <= matrix.length - 1) {
        	if (target == matrix[row][col]) {
        		return true;
        	} else if (target < matrix[row][col]) {
        		col--;
        	} else {
        		row++;
        	}
        }
        return false;
    }
}