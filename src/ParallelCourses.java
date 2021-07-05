class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n + 1];
        for (int[] r: relations) {
        	graph.computeIfAbsent(r[0], v -> new ArrayList<>()).add(r[1]);
        	++inDegree[r[1]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
        	if (inDegree[i] == 0) {
        		queue.offer(i);
        	}
        }
        int res = 0;
        while (!queue.isEmpty()) {
        	for (int sz = queue.size(); sz > 0; --sz) {
        		int c = queue.poll();
        		--n;
                if (!graph.containsKey(c)) continue;
        		for (int course: graph.remove(c)) {
        			if (--inDegree[course] == 0) {
        				queue.offer(course);
        			}
        		}
        	}
        	++res;
        }
        return n == 0 ? res : -1;
    }
}