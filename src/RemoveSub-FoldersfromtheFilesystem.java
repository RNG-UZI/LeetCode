class Solution {
	class Trie {
		int index = -1;
		Trie[] sub = new Trie[27];
	}

    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {
        	Trie t = root;
        	for (char c: folder[i].toCharArray()) {
        		int idx = c == '/' ? 26 : c - 'a';
        		if (t.sub[idx] == null) {
        			t.sub[idx] = new Trie();
        		}
        		t = t.sub[idx];
        	}
        	t.index = i;
        }
        return bfs(root, folder);
    }

    private List<String> bfs(Trie t, String[] folder) {
    	List<String> res = new ArrayList<>();
    	Queue<Trie> q = new LinkedList<>();
    	q.offer(t);
    	while (!q.isEmpty()) {
    		Trie cur = q.poll();
    		if (cur.index >= 0) {
    			res.add(folder[cur.index]);
    		} 
    		for (int i = 0; i < 27; ++i) {
    			if (cur.sub[i] != null && !(i == 26 && cur.index >= 0)) {
    				q.offer(cur.sub[i]);
    			}
    		}
    	}
    	return res;
    }
}