class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
        	long a = n / m, b = n % m;
            //a+8 to differentiate the 0, 1 or >=2
        	ones += ((a + 8) / 10) * m + (a % 10 == 1 ? 1 : 0) * (b + 1);
        }
        return ones;
    }
}