class LRUCache {

	class Node {
		int key;
		int value;
		Node prev;
		Node next;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	HashMap<Integer, Node> map;
	int capacity, count;
	Node head, tail;



    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	count = 0;
    	map  = new HashMap<>();

    	head = new Node(0, 0);
    	tail = new Node(0, 0);

    	head.next = tail;
    	tail.prev = head;
    	head.prev = null;
    	tail.next = null;
        
    }
    
    public int get(int key) {
        //if map contains the key, return the value, else return -1
        if (map.containsKey(key)) {
        	Node node = map.get(key);
        	deleteNode(node);
        	add(node);
        	return node.value;
        } else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
    	//if key exists, replace its value in the map, remove and add to the front
    	if (map.containsKey(key)) {
    		Node node = map.get(key);
    		node.value = value;
    		deleteNode(node);
    		add(node);
    	} else {
    		Node node = new Node(key, value);
    		map.put(key, node);
    		add(node);
    		count++;
    		//check the capacity
    		if (count > capacity) {
    			Node old = tail.prev;
    			map.remove(old.key);
    			deleteNode(old);
    			count--;
    		}
    	}
        
    }

    // two helper functions

    private void add(Node node) {
    	//add to the front
    	Node recent = head.next;
    	head.next = node;
    	node.next = recent;
    	node.prev = head;
    	recent.prev = node;
    }

    private void deleteNode(Node node) {
    	Node prev = node.prev;
    	Node next = node.next;
    	prev.next = next;
    	next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */