class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length, end = n - n / 20;
        double sum = 0d;
        Arrays.sort(arr);
        for (int i = n / 20; i < end; ++i) {
        	sum += arr[i];
        }
        return sum / (n * 9 / 10);
    }
}