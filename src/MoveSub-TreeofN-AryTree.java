class Solution {
    public Node moveSubTree(Node root, Node p, Node q) {
        Map<Node, Node> parents = new HashMap<>();
        getParents(root, parents);

        if (parents.get(p) == q) {
        	return root;
        }

        if (!isAncestor(p, q, parents)) {
        	removeParentLink(p, parents);
        	q.children.add(p);
        	return root;
        }

        removeParentLink(q, parents);

        if (parents.get(p) == null) {
        	q.children.add(p);
        	return q;
        }

        Node parentP = parents.get(p);
        int n = parentP.children.size();
        for (int i = 0; i < n; ++i) {
        	if (parentP.children.get(i) != p) {
        		continue;
        	}
        	parentP.children.set(i, q);
        	q.children.add(p);
        	break;
        }
        return root;
    }

    private void getParents(Node node, Map<Node, Node> parents) {
    	if (node == null) {
    		return;
    	}
    	for (Node child: node.children) {
    		parents.put(child, node);
    		getParents(child, parents);
    	}
    }

    private boolean isAncestor(Node p, Node q, Map<Node, Node> parents) {
    	while (q != null) {
    		q = parents.get(q);
    		if (q == p) {
    			return true;
    		}
    	}
    	return false;
    }

    private void removeParentLink(Node node, Map<Node, Node> parents) {
    	if (parents.get(node) != null) {
    		parents.get(node).children.remove(node);
    		parents.remove(node);
    	}
    }
}