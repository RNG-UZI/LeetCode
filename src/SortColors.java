class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
        	if(nums[cur] == 0){
        		swap(nums, left++, cur++);
        	}else if(nums[cur] == 1) {
        		cur++;
        	}else {
        		swap(nums, cur, right--);
        	}
        }
    }

    public void swap(int[] nums, int a, int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}