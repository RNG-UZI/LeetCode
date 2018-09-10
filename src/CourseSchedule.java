class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int res = numCourses;
        for(int[] pair: prerequisites) {
        	inDegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
        	if(inDegree[i] == 0) {
        		queue.offer(i);
        	}
        }

        while(!queue.isEmpty()) {
        	int pre = queue.poll();
        	res--;
        	for(int[] pair: prerequisites) {
        		if(pair[1] == pre) {
        			inDegree[pair[0]]--;
        			if(inDegree[pair[0]] == 0) {
        				queue.offer(pair[0]);
        			}
        		}
        	}
        }
        return res == 0;
    }
}