class Solution {
    public int strongPasswordChecker(String password) {
        int res = 0, n = s.length(), lower = 1, upper = 1, digit = 1;
        int[] v = new int[n];
        for (int i = 0; i < n;) {
        	if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') lower = 0;
        	if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') upper = 0;
        	if (s.charAt(i) >= '0' && s.charAt(i) <= '9') digit = 0;
        	int start = i;
        	while (i < n && s.charAt(i) == s.charAt(start)) i++;
        	v[start] = i - start; // num of repetition
        }

        int missType = lower + upper + digit;

        if (n < 6) {
        	res = Math.max(missType, 6 - n);
        } else {
        	int over = Math.max(n - 20, 0), replace = 0;
        	res += over;

        	for (int i = 0; i < n && over > 0; i++) {
        		if (v[i] < 3) continue;
        		if (v[i] % 3 == 0) {
        			v[i] -= 1;
        			over -= 1;
        		}
        	}

        	for (int i = 0; i < n && over > 0; i++) {
        		if (v[i] < 3) continue;
        		if (v[i] % 3 == 1) {
        			v[i] -= Math.min(2, over);
        			over -= 2;
        		}
        	}

        	for (int i = 0; i < n; i++) {
        		if (v[i] >= 3 && over > 0) {
        			int needToRemove = v[i] - 2;
        			v[i] -= over;
        			over -= needToRemove;
        		}
        		if (v[i] >= 3) {
        			replace += v[i] / 3;
        		}
        	}
        	res += Math.max(missType, replace);
        }
        return res;
    }
}