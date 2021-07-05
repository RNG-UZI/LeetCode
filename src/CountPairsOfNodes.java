class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n];
        Map<Integer, Integer> shared = new HashMap<>();
        for (int[] edge: edges) {
        	degree[--edge[0]]++;
        	degree[--edge[1]]++;
        	if (edge[0] < edge[1]) {
        		int tmp = edge[0];
        		edge[0] = edge[1];
        		edge[1] = tmp;
        	}
        	shared.put(edge[0] * 20000 + edge[1], shared.getOrDefault(edge[0] * 20000 + edge[1], 0) + 1);
        }
        int[] sorted = degree.clone();
        Arrays.sort(sorted);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
        	int ans = 0;
        	for (int l = 0, r = sorted.length; l < r;) {
        		if (sorted[l] + sorted[r] > queries[i]) {
        			ans += (r - l);
        			r--;
        		} else {
        			l++;
        		}
        	}
        	// remove invalid pairs
        	for (int k: cnt.keySet()) {
        		int fi = k / 20000;
        		int se = k % 20000;
        		if (degree[fi] + degree[se] > queries[i] && degree[fi] + degree[se] - shared.get(k) <= queries[i]) {
        			ans--;
        		}
        	}
        	res[i] = ans;
        }
        return res;
    }
}