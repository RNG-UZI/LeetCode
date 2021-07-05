class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // base case and initialization
    	if (arr1 == null || arr1.length == 0) return -1;
    	if (arr1.length == 1) return 1;
    	TreeSet<Integer> ts = new TreeSet<>();
    	if (arr2 != null) {
    		for (int n: arr2) {
    			ts.add(n);
    		}
    	}
    	int[][] dp = new int[arr1.length + 1][arr1.length + 1];
    	for (int i = 0; i < dp.length; i++) {
    		Arrays.fill(dp[i], Integer.MAX_VALUE);
    	}
    	dp[0][0] = Integer.MIN_VALUE;

        // dp[i][j] is the minimal value to make arr1[0] ~ arr1[j - 1] strictly increasing
        // with i times of changing values
        for (int j = 1; j < dp.length; j++) {
        	for (int i = 0; i <= j; i++) {
        		if (arr[j - 1] > dp[i][j - 1]) {
        			dp[i][j] = arr1[i][j - 1];
        		}
        		if (i > 0 && ts.higher(dp[i - 1][j - 1]) != null) {
        			dp[i][j] = Math.min(dp[i][j], ts.higher(dp[i - 1][j - 1]));
        		}
        		if (j == dp.length - 1 && dp[i][j] != Integer.MAX_VALUE) {
        			return i;
        		}
        	}
        }
    	return -1;
    }
}