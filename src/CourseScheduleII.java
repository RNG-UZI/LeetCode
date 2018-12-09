class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int k = 0;
        int total = numCourses;
        for (int [] pair: prerequisites) {
        	indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
        	if(indegree[i] == 0) {
        		queue.offer(i);
        	}
        }

        while(!queue.isEmpty()) {
        	int pre = queue.poll();
        	res[k++] = pre;
        	total--;
        	for(int[] pair: prerequisites) {
        		if(pair[1] == pre) {
        			indegree[pair[0]]--;
        			if(indegree[pair[0]] == 0) {
        				queue.offer(pair[0]);
        			}
        		}
        	}
        }
        return total == 0 ? res : new int []{};

    }
}