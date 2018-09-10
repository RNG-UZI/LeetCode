class Solution {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for(int i = 0; i <= n; i++) {
        	for(int j = 0; j < i; j++) {
        		res[i] += res[j] * res[i - 1 - j];
        	}
        }
        return res[n];
    }
}