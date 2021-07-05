class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] res = new int[adjacentPairs.length + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //build graph
        for(int i = 0; i < adjacentPairs.length; i++) {
        	addToGraph(graph, adjacentPairs[i][0], adjacentPairs[i][1]);
        	addToGraph(graph, adjacentPairs[i][1], adjacentPairs[i][0]);
        }
        //find start or end
        int start = 0;
        for (int key: graph.keySet()) {
        	if (graph.get(key).size() == 1) {
        		start = key;
        		break;
        	}
        }
        //dfs
        Set<Integer> seen = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        dfs(start, graph, ans, seen);
        for (int i = 0; i < ans.size(); i++) {
        	res[i] = ans.get(i);
        }
        return res;
    }

    private void addToGraph(Map<Integer, List<Integer>> graph, int key, int value) {
    	if (graph.containsKey(key)) {
    		graph.get(key).add(value);
    	} else {
    		List<Integer> temp = new ArrayList<>();
    		temp.add(value);
    		graph.put(key, temp);
    	}
    }

    private void dfs(int start, Map<Integer, List<Integer>> graph, List<Integer> ans, Set<Integer> seen) {
    	ans.add(start);
    	seen.add(start);
    	List<Integer> neighbours = graph.get(start);
    	for (Integer cur: neighbours) {
    		if (!seen.contains(cur)) {
    			dfs(cur, graph, ans, seen);
    		}
    	}
    }
}