class WordDictionary {

	class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public String word = "";
	}
	private TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
        	if (node. children[c - 'a'] == null) {
        		node. children[c - 'a'] = new TrieNode();
        	}
        	node = node.children[c - 'a'];
        }
        node.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, 0, root);
    }

    private boolean match(String word, int k , TrieNode node) {
    	char[] ch_arr = word.toCharArray();
    	if (k==ch_arr.length) return !node.word.equals("");
    	if (ch_arr[k] != '.') {
    		return node.children[ch_arr[k] - 'a'] != null && match(word, k+1, node.children[ch_arr[k] - 'a']);
    	} else {
    		for (int i = 0; i < node.children.length; i++) {
    			if (node.children[i] != null) {
    				if (match(word, k + 1, node.children[i])) {
    					return true;
    				}

    			}
    		}
    	}
    	return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */