class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            map.put(prerequisites[i][0], new ArrayList());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && !dfs(i)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int node) {
        if (visited.contains(node)) {
            return false;
        }

        var nextNode = map.get(node);
        if (nextNode == null) {
            return true;
        }
        
        visited.add(node);
        for (Integer n : nextNode) {
            if (!dfs(n)) {
                return false;
            }
        }
        visited.remove(node);
        map.put(node, new ArrayList<>());

        return true;
    }
}

