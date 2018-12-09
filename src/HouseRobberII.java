class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int begin, int end) {
    	int n = end - begin + 1;
    	int[] res = new int[n];
    	res[0] = nums[begin];
    	res[1] = Math.max(nums[begin], nums[begin+1]);

    	for(int i = 2; i < n; i++) {
    		res[i] = Math.max(res[i-2] + nums[begin + i], res[i - 1]);
    	}
    	return res[n - 1];
    }
}