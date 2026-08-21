class Solution {

    Map<Integer, Integer> mem = new HashMap<>();
    int maxRow = 0;
    int maxCol = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        maxRow = obstacleGrid.length - 1;
        maxCol = obstacleGrid[0].length - 1;

        return dfs(obstacleGrid, 0, 0);
    }

    int dfs(int[][] grid, int row, int col) {
        if (row > maxRow || col > maxCol) {
            return 0;
        }
        if (grid[row][col] == 1) {
            return 0;
        }
        if (row == maxRow && col == maxCol) {
            return 1;
        }

        var key = row * (maxCol + 1) + col;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        var res = dfs(grid, row + 1, col) + 
                  dfs(grid, row, col + 1); 
        mem.put(key, res);

        return res;
    }
}