class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num: nums) {
        	set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
        	int down = nums[i] - 1;
        	while (set.contains(down)) {//delete the number that has been visited
        		set.remove(down);
        		down--;
        	}
        	int up = nums[i] + 1;
        	while (set.contains(up)) {
        		set.remove(up);
        		up++;
        	}
        	res = Math.max(res, up - down - 1);
        }
        return res;
    }
}