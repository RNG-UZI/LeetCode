class Solution {//time O(n) space O(1)
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;
        while(sp < s.length()) {
        	if(pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
        		sp++;//if match, simple
        		pp++;
        	} else if(pp < p.length() && p.charAt(pp) == '*') {
        		star = pp;//if '*', update star match
        		match = sp;
        		pp++;
        	} else if(star != -1) {//if not '*' and not match, move sp and match
        		pp = star + 1;
        		match++;
        		sp = match;
        	} else return false;
        }
        while(pp < p.length() && p.charAt(pp) == '*') {//to see if the rest of p is all '*'
        	pp++;//to see if the rest of p is all '*'
        }
        //if pp can move to the end, match
        return pp == p.length();
    }
}