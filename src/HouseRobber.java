class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int curStolen = 0;
        int curNotStolen = 0;
        for(int num: nums) {
        	int temp = curNotStolen;
        	curNotStolen = Math.max(curNotStolen, curStolen);
        	curStolen = temp + num;
        }
        return Math.max(curStolen, curNotStolen);
    }
}