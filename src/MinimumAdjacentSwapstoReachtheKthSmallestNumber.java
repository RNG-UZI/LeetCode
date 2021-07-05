class Solution {
    public int getMinSwaps(String num, int k) {
        char[] arr = num.toCharArray();
        for (int i = 0; i < k; i++) {
        	nextPermutation(arr);
        }
        char[] ori = num.toCharArray();
        return countMinSteps(ori, arr, arr.length);
    }

    private void nextPermutation(char[] nums) {
    	if (nums.length == 0) return;
    	for (int i = nums.length - 1; i >= 1; i--) {
    		if (nums[i] > nums[i - 1]) {
    			reverse(nums, i);
    			for (int j = i; j < nums.length; j++) {
    				if (nums[j] > nums[i - 1]) {
    					swap(nums, i - 1, j);
    					return;
    				}
    			}
    		}
    	}
    	reverse(nums, 0);
    }

    private void reverse(char[] nums, int i) {
    	int j = nums.length - 1;
    	while (i < j) {
    		swap(nums, i, j);
    		i++;
    		j--;
    	}
    }

    private void swap(char[] nums, int i, int j) {
    	char tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }

    private int countMinSteps(char[] s1, char[] s2, int size) {
    	int i = 0, j = 0, res = 0;
    	while (i < size) {
    		j = i;
    		while (s1[j] != s2[i]) {
    			j++;
    		}
    		while (i < j) {
    			swap(s1, j , j - 1);
    			j--;
    			res++;
    		}
    		i++;
    	}
    	return res;
    }
}