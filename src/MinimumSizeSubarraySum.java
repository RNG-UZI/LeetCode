class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
        	sum = sum + nums[i];//make window bigger
        	while(left <= i && sum >= s) {
        		res = Math.min(res, i - left + 1);
        		sum -= nums[left++];//make window smaller
        	}
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}