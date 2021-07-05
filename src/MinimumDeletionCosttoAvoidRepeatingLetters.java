class Solution {
    public int minCost(String s, int[] cost) {
        int[] count = {0, 0, 0}, res = 0, left = 0, n = s.length();
        for (int right = 0; right < n; right++) {
        	++count[s.charAt(right) - 'a'];
        	while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
        		--count[s.charAt(left++) - 'a'];
        	}
        	res += left;
        }
        return res;
    }
}