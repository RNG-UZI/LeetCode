class MajorityChecker {
	//segment tree array
	int[] st;
	int[] arr;
	Map<Integer, List<Integer>> numAppMap;

    public MajorityChecker(int[] arr) {
    	int n = arr.length;
    	int sz = 2 * (int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) - 1;
    	this.st = new int[sz];
    	this.arr = new int[n];
    	numAppMap = new HashMap<>();
    	for (int i = 0; i < n; i++) {
    		this.arr[i] = arr[i];
    		int num = arr[i];
    		numAppMap.putIfAbsent(num, new ArrayList<>());
    		numAppMap.get(num).add(i);
    	}
    	buildTree(0, n - 1, 0);
    }
    
    public int query(int left, int right, int threshold) {
        int val = queryUtil(0, this.arr.length - 1, left, right, 0);
        if (val != -1 && getOccur(val, left, right) >= threshold) {
        	return val;
        }
        return -1;
    }

    private int buildTree(int start, int end, int si) {
    	if (end < start) return -1;
    	if (start == end) {
    		this.st[si] = this.arr[start];
    		return this.st[si];
    	}
    	int mid = start + (end - start) / 2;
    	int left = buildTree(start, mid, 2 * si + 1);
    	int right = buildTree(mid + 1, end, 2 * si + 2);
    	this.st[si] = -1;
    	if (left != -1 && getOccur(left, start, end) * 2 > end - start + 1) {
    		this.st[si] = left;
    	} else if (right != -1 && getOccur(right, start, end) * 2 > end - start + 1) {
    		this.st[si] = right;
    	}
    	return this.st[si];
    }

    private int queryUtil(int ss, int se, int qs, int qe, int si) {
    	if (qs > se || qe < ss) return -1;
    	if (qs <= ss && qe >= se) {
    		int cand = this.st[si];
    		if (cand != -1 && getOccur(cand, qs, qe) * 2 > qe - qs + 1) {
    			return cand;
    		} else {
    			return -1;
    		}
    	}
    	int mid = ss + (se - ss) / 2;
    	int left = queryUtil(ss, mid, qs, qe, 2 * si + 1);
    	if (left != -1 && getOccur(left, qs, qe) * 2 > qe - qs + 1) {
    		return left;
    	}
    	int right = queryUtil(mid + 1, se, qs, qe, 2 * si + 2);
    	if (right != -1 && getOccur(right, qs, qe) * 2 > qe - qs + 1) {
    		return right;
    	}
    	return -1;
    }

    private int getOccur(int num, int l, int r) {
    	int res = 0;
    	if (numAppMap.containsKey(num)) {
    		List<Integer> indexes = numAppMap.get(num);
    		int n = indexes.size();
    		int l1 = 0, r1 = n;
    		while (l1 < r1) {
    			int m1 = l1 + (r1 - l1) / 2;
    			if (indexes.get(m1) >= l) {
    				r1 = m1;
    			} else {
    				l1 = m1 + 1;
    			}
    		}
    		int l2 = 0, r2 = n;
    		while (l2 < r2) {
    			int m2 = l2 + (r2 - l2) / 2;
    			if (indexes.get(m2) > r) {
    				r2 = m2;
    			} else {
    				l2 = m2 + 1;
    			}
    		}
    		return l2 - l1;
    	}
    	return res;
    }
}