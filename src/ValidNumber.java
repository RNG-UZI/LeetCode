class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        //check leading space
        int i = 0;
        int n = s.length();
        while(i < n && Character.isWhitespace(s.charAt(i))) i++;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isDigits = false;
        while(i < n && Character.isDigit(s.charAt(i))) {
        	i++;
        	isDigit = true;
        }
        //check point
        if(i < n && s.charAt(i) == '.') {//.5 and 3. is valid
        	i++;
        	while(i < n && Character.isDigit(s.charAt(i))) {
        		isDigit = true;
        		i++;
        	}
        }
        if(i < n && s.charAt(i) == 'e' && isDigits) {
        	i++;
        	isDigits = false;//must have digit after e
        	if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        	while(i < n && Character.isDigit(s.charAt(i))) {
        		i++;
        		isDigit = true;
        	}
        } 
        while(i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isDigits && i == s.length();
    }
}