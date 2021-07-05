class Solution {
    public int guessMajority(ArrayReader reader) {
        int n = reader.length();
        int start = reader.query(0, 1, 2, 3), g1 = 1, g2 = 0, idx1 = 0, idx2 = -1;
        for (int i = 4; i < n; i++) {
        	if (reader.query(1, 2, 3, i) == start) {
        		g1++;
        	} else {
        		g2++;
        		idx2 = i;
        	}
        }
        int q = reader.query(0, 2, 3, 4);
        int p = reader.query(1, 2, 3, 4);
        if (p == q) {
        	g1++;
        } else {
        	g2++;
        	idx2 = 1;
        }
        q = reader.query(0, 1, 3, 4);
        if (p == q) {
        	g1++;
        } else {
        	g2++;
        	idx2 = 2;
        }
        q = reader.query(0, 1, 2, 4);
        if (p == q) {
        	g1++;
        } else {
        	g2++;
        	idx2 = 3;
        }
        return g1 == g2 ? -1 : (g1 > g2 ? idx1 : idx2);
    }
}