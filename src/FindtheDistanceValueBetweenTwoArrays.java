class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int curVal: arr1) {
        	int closestVal = findClosestValue(arr2, curVal);
        	if (Math.abs(curVal - closestVal) > d) {
        		res++;
        	}
        }
        return res;
    }

    private int findClosestValue(int[] arr, int val) {
    	int l = 0, r = arr.length - 1;
    	while (l + 1 < r) {
    		int mid = l + (r - l) / 2;
    		if (arr[mid] < val) {
    			l = mid;
    		} else {
    			r = mid;
    		}
    	}
    	return Math.abs(arr[l] - val) < Math.abs(arr[r] - val) ? arr[l] : arr[r];
    }
}