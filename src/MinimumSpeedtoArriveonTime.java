class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int min = 1, max = 10000000, res = -1;
        while (min <= max) {
        	int mid = (max + min) / 2;
        	double sum = 0;
        	for (int i = 0; i < dist.length - 1; i++) {
        		sum += Math.ceil((double)dist[i] / mid);
        	}
        	sum += ((double) dist[dist.length - 1] / mid);
        	if (sum > hour) {
        		min = mid + 1;
        	} else {
        		res = mid;
        		max = mid - 1;
        	}
        }
        return res;
    }
}