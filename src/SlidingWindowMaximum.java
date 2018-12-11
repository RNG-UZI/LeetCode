class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if (nums == null || nums.length == 0) {
    		return new int[0];
    	}
    	Deque<Integer> deque = new LinkedList<>();
    	int[] res = new int[nums.length - k + 1];
    	for (int i = 0; i < nums.length; i++) {
    		//out of bounds
    		if (!deque.isEmpty() && deque.peekFirst() == i - k) {
    			deque.poll();
    		}
    		//the newer one is bigger, delete the last
    		while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
    			deque.removeLast();
    		}
    		deque.offerLast(i);
    		//filling in the array
    		if ((i + 1) >= k) {
    			res[i - k + 1] = nums[deque.peek()];
    		}
    	}
    	return res;
    }
}