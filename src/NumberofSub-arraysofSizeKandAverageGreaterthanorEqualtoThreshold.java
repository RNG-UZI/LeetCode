class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0, total = arr.length - k + 1, t = threshold * k, sum = 0;
        for (int i = 0; i < k; ++i) {
        	sum += arr[i];
        }
        if (sum > t) res++;
        for (int i = k; i < total; ++i) {
        	sum -= arr[i - k];
        	sum += arr[k];
        	if (sum > t) res++;
        }
        return res;
    }
}