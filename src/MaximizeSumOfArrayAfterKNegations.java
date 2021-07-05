class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; k > 0 && i < nums.length && nums[i] < 0; ++i, --k) {
        	nums[i] = -nums[i];
        }
        int res = 0, minPos = Integer.MAX_VALUE;
        for (int n: nums) {
        	res += n;
        	minPos = Math.min(minPos, n);
        }
        return res - (k % 2) * minPos * 2;
    }
}