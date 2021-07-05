class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
        	if (s.charAt(i) == '(') {
        		opened.push(i);
        	}
        	if (s.charAt(i) == ')') {
        		int j = opened.pop();
        		pair[i] = j;
        		pair[j] = i;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, step = 1; i < n; i += step) {
        	if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        		i = pair[i];
        		step = -step;
        	} else {
        		sb.append(s.charAt(i));
        	}
        }
        return sb.toString();
    }
}