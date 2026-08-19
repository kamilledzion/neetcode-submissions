class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];

            map.computeIfAbsent(from, v -> new ArrayList<>()).add(to);
            indegree[to]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.addLast(i);
            }
        }

        int completed = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.pollFirst();            
            completed++;

            if (map.get(node) != null) {
                for (Integer nei : map.get(node)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        queue.addLast(nei);
                    }
                }
            }
        }

        return completed == numCourses;
    }
}

