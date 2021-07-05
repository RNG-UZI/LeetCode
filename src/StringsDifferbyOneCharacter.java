class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < dict.length; ++i) {
        	char[] ch = dict[i].toCharArray();
        	for (int j = 0; j < ch.length; ++j) {
        		char temp = ch[j];
        		ch[j] = '*';
        		if (seen.contains(String.valueOf(ch))) {
        			return true;
        		}
        		seen.add(String.valueOf(ch));
        		ch[j] = temp;
        	}
        }
        return false;
    }
}