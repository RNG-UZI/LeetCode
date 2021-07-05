class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
        	map[i] = i;
        }
        List<Tuple> list = new LinkedList<>();
        for (int i = 0; i < queries.length; i++) {
        	list.add(new Tuple(i, queries[i]));
        }
        Collections.sort(list, (a, b)->Integer.compare(a.q[2], b.q[2]));
        Arrays.sort(edgeList, (a, b)->Integer.compare(a[2], b[2]));
        boolean[] res = new boolean[queries.length];
        int j = 0;
        for (Tuple t: list) {
        	while (j < edgeList.length && edgeList[j][2] < t.q[2]) {
        		int a = find(map, edgeList[j][0]);
        		int b = find(map, edgeList[j][1]);
        		if (a != b) {
        			map[a] = b;
        		}
        		j++;
        	}
        	res[t.index] = find(map, t.q[0]) == find(map, t.q[1]);
        }
        return res;
    }

    private int find(int[] map, int i) {
    	while (map[i] != i) {
    		map[i] = map[map[i]];
    		i = map[i];
    	}
    	return i;
    }

    class Tuple{
    	int index;
    	int[] q;
    	public Tuple(int i, int[] q) {
    		this.index = i;
    		this.q = q;
    	}
    }
}