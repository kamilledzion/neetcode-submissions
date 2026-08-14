class Solution {
    
    int maxRow = 0;
    int maxCol = 0;
    int[][] directions = new int[][] {
            {  1,  0 },
            { -1,  0 },
            {  0,  1 },
            {  0, -1 },
            {  1,  1 },
            { -1,  1 },
            {  1, -1 },
            { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        maxRow = grid.length;
        maxCol = grid[0].length;
        var length1 = 0;
        var length2 = 0;
        Deque<int[]> queue1 = new ArrayDeque<>();
        Deque<int[]> queue2 = new ArrayDeque<>();

        if (grid[0][0] == 1 || grid[maxRow - 1][maxCol - 1] == 1) {
            return -1;
        }

        if (grid[0][0] == 0 && 
            maxRow - 1 == 0 && maxCol - 1 == 0) {
            
            return 1;
        }

        queue1.add(new int[]{0, 0});
        grid[0][0] = -1;
        length1++;

        queue2.add(new int[]{maxRow - 1, maxCol - 1});
        grid[maxRow - 1][maxCol - 1] = -2;
        length2++;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            if (queue1.size() <= queue2.size()) {
                if (bfs(grid, queue1, -1)) {
                    return length1 + length2;
                }
                length1++;
            } else {
                if (bfs(grid, queue2, -2)) {
                    return length2 + length1;
                }
                length2++;
            }
        }
        return -1;  
    }

    boolean bfs(int[][] grid, Deque<int[]> queue, int mark) {
        var size = queue.size();
        int targetMark = (mark == -1) ? -2 : -1;
        
        for (int i = 0; i < size; i++) {
            var value = queue.pollFirst();
            var row = value[0];
            var col = value[1];

            for (int[] d : directions) {
                var nextRow = row + d[0];
                var nextCol = col + d[1];

                if (nextRow >= 0 && nextRow < maxRow &&
                    nextCol >= 0 && nextCol < maxCol) {
                    
                    if (grid[nextRow][nextCol] == targetMark) {        
                        return true;
                    } 

                    if (grid[nextRow][nextCol] == 0) {
                        
                        grid[nextRow][nextCol] = mark;
                        queue.addLast(new int[] { nextRow, nextCol });
                    }
                }
            }
        }
        return false;
    }
}