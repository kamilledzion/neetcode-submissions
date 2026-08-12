class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        var maxRow = grid.length;
        var maxCol = grid[0].length;
        var length = 0;
        Deque<int[]> queue = new ArrayDeque<>();
    
        if (grid[0][0] == 1 || grid[maxRow - 1][maxCol - 1] == 1) {
            return -1;
        }

        if (grid[0][0] == 0 && maxRow - 1 == 0 && maxCol - 1== 0) {
            return 1;
        }

        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            length++;
            
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var value = queue.pollLast();
                var row = value[0];
                var col = value[1];

                if (grid[row][col] == 0) {
                    grid[row][col] = 1;
                    if (row == maxRow - 1 && col == maxCol - 1) {
                        return length;
                    }

                    if (row + 1 >= 0 && row + 1 <= maxRow - 1) {
                        queue.addFirst(new int[]{row + 1, col});
                    }
                    if (row - 1 >= 0 && row - 1 <= maxRow - 1) {
                        queue.addFirst(new int[]{row - 1, col});
                    }
                    if (col + 1 >= 0 && col + 1 <= maxCol - 1) {
                        queue.addFirst(new int[]{row, col + 1});
                    }
                    if (col - 1 >= 0 && col - 1 <= maxCol - 1) {
                        queue.addFirst(new int[]{row, col - 1});
                    }

                    if (row + 1 >= 0 && row + 1 <= maxRow - 1 && 
                        col + 1 >= 0 && col + 1 <= maxCol - 1) {

                        queue.addFirst(new int[]{row + 1, col + 1});
                    }
                    if (row - 1 >= 0 && row - 1 <= maxRow - 1 &&
                        col - 1 >= 0 && col - 1 <= maxCol - 1) {

                        queue.addFirst(new int[]{row - 1, col - 1});
                    }
                    if (row + 1 >= 0 && row + 1 <= maxRow - 1 && 
                        col - 1 >= 0 && col - 1 <= maxCol - 1) {

                        queue.addFirst(new int[]{row + 1, col - 1});
                    }
                    if (row - 1 >= 0 && row - 1 <= maxRow - 1 &&
                        col + 1 >= 0 && col + 1 <= maxCol - 1) {

                        queue.addFirst(new int[]{row - 1, col + 1});
                    }
                }
            }
        }
        return -1;  
    }
}