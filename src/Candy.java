class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        //scan from left
        for (int i = 1; i < candies.length; i++) {
        	if (ratings[i - 1] < ratings[i]) {
        		candies[i] = candies[i - 1] + 1;
        	}
        }

        //scan from right
        for (int i = candies.length - 1; i > 0; i--) {
        	if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
        		candies[i -1] = candies[i] + 1;
        	}
        }
        int res = 0;
        for (int i = 0; i < candies.length; i++) {
        	res += candies[i];
        }
        return res;
    }
}