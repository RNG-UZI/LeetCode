class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; ++i) {
        	parent[i] = i;
        }
        for (int i = 0; i < A.length(); ++i) {
        	int a = A.charAt(i) - 'a';
        	int b = B.charAt(i) - 'a';
        	int parent1 = find(parent, a);
        	int parent2 = find(parent, b);
        	if (parent1 < parent2) {
        		parent[parent2] = parent1;
        	} else {
        		parent[parent1] = parent2;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); ++i) {
        	char c = S.charAt(i);
        	sb.append((char)('a' + find(parent, c - 'a')));
        }
        return sb.toString();
    }

    private int find(int[] parent, int idx) {
    	while (parent[idx] != idx) {
    		idx = parent[idx];
    	}
    	return idx;
    }
}