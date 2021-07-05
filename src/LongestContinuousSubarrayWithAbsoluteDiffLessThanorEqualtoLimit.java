class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
        	while (!maxd.isEmpty() && nums[right] > maxd.peekLast()) maxd.pollLast();
        	while (!mind.isEmpty() && nums[right] < mind.peekLast()) mind.pollLast();
        	maxd.add(nums[right]);
        	mind.add(nums[right]);
        	if (maxd.peek() - mind.peek() > limit) {
        		if (maxd.peek() == nums[left]) maxd.poll();
        		if (mind.peek() == nums[left]) mind.poll();
        		left++;
        	}
        }
        return right - left;
    }
}