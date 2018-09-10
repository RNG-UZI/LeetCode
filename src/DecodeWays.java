class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int size = s.length();
        if(s.charAt(0) == '0') return 0;
        int preWays = 1;//the first i - 2
        int curWays = 1;//the first i - 1
        for(int i = 1; i < size; i++) {
        	int tmp = curWays;
        	if(s.charAt(i) == '0') {//must have one condition, i-2 and {i, i - 1}
        		curWays = preWays;
        		if(s.charAt(i - 1) >= '3' || s.charAt(i - 1) <='0') {
        			return 0;
        		}
        	} else {
        		if(s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) {
        			curWays +=preWays;
        		}
        	}
        	preWays = tmp;
        }
        return curWays;
    }
}