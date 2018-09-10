class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() > 12) return res;
        helper(s, res, "", 0);
        return res;
    }

    public void helper(String s, List<String> res, String cur, int field) {
    	if(s.length() == 0 && field == 4) {
    		res.add(cur.substring(1));//leave out '.'
    	} else if (s.length() == 0 || field == 4) {
    		return;
    	} else {
    		helper(s.substring(1), res, cur + '.' + s.substring(0, 1), field + 1);
    		if(s.charAt(0) != '0' && s.length() > 1) {
    			helper(s.substring(2), res, cur + '.' + s.substring(0, 2), field + 1);
    			if(s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255) {
    				helper(s.substring(3), res, cur + '.' + s.substring(0, 3), field + 1);
    			}
    		}
    	}

    }
}