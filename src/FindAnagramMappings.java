class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
 		if (A == null || B == null || A.length != B.length) {
 			return new int [0];
 		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < B.length; i++) {
			map.put(B[i], i);
		}

		int[] res = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			res[i] = map.get(A[i]);
		}

 		return res;
    }
}