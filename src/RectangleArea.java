class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int square1 = (C - A) * (D - B);
        int square2 = (G - E) * (H - F);

        int overlap = overlap(A, B, C, D, E, F, G, H);
        return square1 + square2 - overlap;
    }

    private int overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int x1 = Math.max(A, E);
    	int x2 = Math.min(C, G);
    	int x = x2 - x1;

    	int y1 = Math.max(B, F);
    	int y2 = Math.min(D, H);
    	int y = y2 - y1;

    	if (x <= 0 || y <= 0) {
    		return 0;
    	} else {
    		return x * y;
    	}

    }
}