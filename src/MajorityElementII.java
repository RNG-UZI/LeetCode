class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return new ArrayList<>();
        }
        //find the number
        List<Integer> res = new ArrayList<>();
        int num1 = 0, num2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == num1) {
        		cnt1++;
        	} else if (nums[i] == num2) {
        		cnt2++;
        	} else if (cnt1 == 0) {
        		num1 = nums[i];
        		cnt1 = 1;
        	} else if (cnt2 == 0) {
        		num2 = nums[i];
        		cnt2 = 1;
        	} else {
        		cnt1--;
        		cnt2--;
        	}
        }
        //count again
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == num1) {
        		cnt1++;
        	} else if (nums[i] == num2) {
        		cnt2++;
        	}
        }
        if (cnt1 > nums.length / 3) res.add(num1);
        if (cnt2 > nums.length / 3) res.add(num2);
        return res;
    }
}