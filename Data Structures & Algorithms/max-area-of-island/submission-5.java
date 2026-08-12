class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        var maxRow = grid.length;
        var maxCol = grid[0].length;
        var area = 0;

        Deque<int[]> queue = new ArrayDeque<>();
    
        for (int r = 0; r < maxRow; r++) {
            for (int c = 0; c < maxCol; c++) {
                if (grid[r][c] == 1) {
                    queue.add(new int[]{r, c});
                    var count = 0;

                    while (!queue.isEmpty()) {
                        var value = queue.pollLast();
                        var row = value[0];
                        var col = value[1];

                        if (grid[row][col] == 1) {
                            grid[row][col] = 0;
                            count++;

                            if (row + 1 >= 0 && row + 1 <= maxRow - 1) {
                                queue.add(new int[]{row + 1, col});
                            }
                            if (row - 1 >= 0 && row - 1 <= maxRow - 1) {
                                queue.add(new int[]{row - 1, col});
                            }
                            if (col + 1 >= 0 && col + 1 <= maxCol - 1) {
                                queue.add(new int[]{row, col + 1});
                            }
                            if (col - 1 >= 0 && col - 1 <= maxCol - 1) {
                                queue.add(new int[]{row, col - 1});
                            }
                        }
                    }
                    area = Math.max(area, count);
                }
            }
        }
        return area;   
    }
}
