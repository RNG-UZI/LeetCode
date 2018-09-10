class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
        	return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0, true);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int cur, boolean used) {
    	if(cur == nums.length) {
    		res.add(new ArrayList<>(list));
    	} else {
    		helper(res, list, nums, cur + 1, false);
    		if(used || nums[cur - 1] != nums[cur]) {
    			list.add(nums[cur]);
    			helper(res, list, nums, cur + 1, true);
    			list.remove(list.size() - 1);
    		}
    	}
    }
}