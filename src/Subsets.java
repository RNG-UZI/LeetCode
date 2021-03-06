class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
        	return res;
        }
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
    	res.add(new ArrayList<>(list));
    	for(int i = start; i < nums.length; i++) {
    		list.add(nums[i]);
            System.out.println(i);
            System.out.println(list);
    		helper(res, list, nums, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
}

