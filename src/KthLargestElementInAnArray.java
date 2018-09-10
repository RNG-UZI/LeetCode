class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
        	pq.offer(num);
        	if(pq.size() > k) {
        		pq.poll();
        	}
        }
        return pq.poll();
    }
}