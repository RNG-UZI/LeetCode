class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        /*
        int min = matrix[0][0];
        int max = matrix[m - 1][n - 1];
        if(target < min || target > max) {
        	return false;
        }
        */
        int begin = 0;
        int end = m * n - 1;
        while(begin <= end) {
        	int mid = (end - begin) / 2 + begin;
            //System.out.println(mid);
        	int val = matrix[mid / n][mid % n];
        	if(val == target) {
        		return true;
        	} else if(val < target) {
        		begin = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        return false;
    }
}